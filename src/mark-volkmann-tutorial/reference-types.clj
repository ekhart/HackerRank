;; Reference Types
;; http://java.ociweb.com/mark/clojure/article.html#ReferenceTypes

;; mutable references to immutable data: Vars, Refs, Atoms, Agents
; hold any kind of object
; deref, @ - get its value
; validators - functions called when they changed -> IllegalStateException
; watchers - Agents - when value changed - Agents is notified

; table: purpose, create, modify


;; Vars
; have root binding shared by all threads, diff value in each

; create var, optional value (if not = unboud)
;; (def name value)

; thread-local binding for existing Var
;; (binding [name expression] body)
;; (set! name expression)   ; inside a binding that bound the same name

(def ^:dynamic v 1)   ; need "dynamic" metadata so v can be changed in a binding

(defn change-it []
  (println "2) v =" v) ; 1

  (def v 2) ; changes root value
  (println "3) v =" v) ; 2

  (binding [v 3] ; binds a thread-local value
    (println "4) v =" v) ; 3

    (set! v 4) ; changes thread-local value
    (println "5) v =" v)) ; 4

  (println "6) v =" v)) ; thread-local value is gone now -> 2

(println "1) v =" v) ; 1

(let [thread (Thread. #(change-it))]
  (.start thread)
  (.join thread)) ; wait for thread to finish

;; ! values are not coordinated across thraeds


;; Refs
; coordinated chabges between multiple threads using STM (Software Transactional Memory)
; ref modified only in transaction
; STM ~ database transactions: commit; atomic & isolation; validator function
; dosync - transaction: in it ref have private value dont visible for other threads
; if there is no exception before end of transaction - its committed, and it visible
; if exception -> rollback changes
; transaction should be side-effect free -> its could be called multiple times (retry on conflict)

;; (def name (ref value)

(dosync
  ; ...
  (ref-set name new-value)
  ; ...
  )

;; If the new value must be computed from the old value then three steps are required.
;; 1 deference the Ref to get the old value
;; 2 compute the new value
;; 3 set the new value
;; alter - changes in specific oreder
;; commute - order of changes are not imporant - could be done parallel

(dosync
;;   ...
  (alter counter inc)
  ; or as
  (commute counter inc)   ; faster (parallel) but not deterministic, optimization of alter
;;   ...
)


(ns com.ociweb.bank)

; Assume the only account data that can change is its balance.
(defstruct account-struct :id :owner :balance-ref)

; We need to be able to add and delete accounts to and from a map.
; We want it to be sorted so we can easily
; find the highest account number
; for the purpose of assigning the next one.
(def account-map-ref (ref (sorted-map)))

(defn open-account
  "creates a new account, stores it in the account map and returns it"
  [owner]
  (dosync ; required because a Ref is being changed
    (let [account-map @account-map-ref
          last-entry (last account-map)
          ; The id for the new account is one higher than the last one.
          id (if last-entry (inc (key last-entry)) 1)
          ; Create the new account with a zero starting balance.
          account (struct account-struct id owner (ref 0))]
      ; Add the new account to the map of accounts.
      (alter account-map-ref assoc id account)
      ; Return the account that was just created.
      account)))

(defn deposit [account amount]
  "adds money to an account; can be negative amount"
  (dosync ; required because a Ref is being changed
    (Thread/sleep 50) ; simulate a long-running operation
    (let [owner (account :owner)
          balance-ref (account :balance-ref)
          type (if (pos? amount) "deposit" "withdraw")
          direction (if (pos? amount) "to" "from")
          abs-amount (Math/abs amount)]
      (if (>= (@balance-ref amount) 0) ; sufficient balance?
        (do
          (alter balance-ref + amount)
          (println (str type "ing") abs-amount direction owner))
        (throw (IllegalArgumentException.
                 (str "insufficient balance for " owner " to withdraw " abs-amount)))))))

(defn withdraw
  "removes money from an account"
  [account amount]
  ; A withdrawal is lika a negative deposit.
  (deposit account (- amount)))

(defn transfer [from-account to-account amount]
  (dosync
    (println "transferring" amount
             "from" (from-account :owner)
             "to" (to-account :owner))
    (withdraw from-account amount)
    (deposit to-account amount)))

(defn- report-1 ; a private function
  "prints information about a single account"
  [account]
  ; This assumes it is being called from within
  ; the transaction started in reporrt/
  (let [balance-ref (account :balance-ref)]
    (println "balance for" (account :owner) "is" @balance-ref)))

(defn report
  "prints information about any number of accounts"
  [& accounts]
  (dosync
    (doseq [account accounts]
      (report-1 account))))

; set a default uncaught exception handler
; to handle exceptions not caught in other threads.
(Thread/setDefaultUncaughtExceptionHandler
  (proxy [Thread$UncaughtExceptionHandler] []
    (uncaughtException [thread throwable]
                       ; Just print the exception
                       (println (.. throwable .getCause .getMessage)))))

(let [a1 (open-account "Mark")
      a2 (open-account "Tami")
      thread (Thread. #(transfer a1 a2 50))]
  (try
    (deposit a1 100)
    (deposit a2 200)

    ; There are sufficient fund in Mark's account at this point
    ; to transfer $50 to Tami's account.
    (.start thread) ; will sleep in deposit function twice!

    ; Unfortunately, due to the time it takes to complete the transfer
    ; (simulated with sleep calls), the next call will complete first.
    (withdraw a1 75)

    ; Now there ara insufficient fund in Mark's account
    ; to complete the transfer.

    (.join thread)   ; wait for thread to finish
    (report a1 a2)
    (catch IllegalAccessException e
      (println (.getMessage e) "in main thread"))))


;; Validation functions
; Note the use of the :validator directive when creating the Ref
; to assign a validation function which is integer? in this case.
(def my-ref (ref 0 :validator integer?))

(try
  (dosync
    (ref-set my-ref 1) ; works

    ; The next line doesn't work, so the transaction is rolled back
    ; and the previous change isn't commited.
    (ref-set my-ref "foo"))
  (catch IllegalStateException e
    ; do nothing
    ))

(println "my-ref =" @my-ref) ; due to validation failure -> 0



;; Atoms - update single value - simpler than Ref
;; functions: reset!, compare-and-set!, swap!

; reset! - set new value without validation
(def my-atom (atom 1))
(reset! my-atom 2)
(println @my-atom)

; compare-and-set!
; called at end of binding
(def my-atom (atom 1))

(defn update-atom []
  (let [curr-val @my-atom]
    (println "update-atom: curr-val =" curr-val) ; -> 1
    (Thread/sleep 50) ; give reset! time to run
    (println
      (compare-and-set! my-atom (inc curr-val))))) ; -> false

(let [thread (Thread. #(update-atom))]
  (.start thread)
  (Thread/sleep 25) ; give thread time to call update-atom
  (reset! my-atom 3) ; happends after update-atom binds curr-val
  (.join thread)) ; wait for thread to finish

(println @my-atom) ; -> 3


;; Agents
; used to run tasks in separate threads
; modify state of single object in separate thread
;; agent - create agent
;; (def m-agent (agent initial-value))

;; send - dispatch function, send-off similar, but using other thread pool
;; send use number of CPU + 2 threads
;; current agent - *agent*
;; await, await-for
;; agent-errors - exceptions, clear-agent-errors
;; shutdown-agents


;; Watchers
; add-watch, remove-watch
; agents as watchers

; easy find not-pure functions (chaning global state)
; 1 find source of small set of funs that change global state (e.g alter)
; or use watchers to detect changes

;;; deprecated use
;; (def my-watcher (agent {}))

;; (defn my-watcher-action [current-value reference]
;;   (let [change-count-map current-value
;;         old-count (change-count-map reference)
;;         new-count (if old-count (inc old-count) 1)]
;;   ; Return an updated map of change counts
;;   ; that will become the new value of the Agent.
;;   (assoc change-count-map reference new-count)))

;; (def my-var "v1")
;; (def my-ref (ref "r1"))
;; (def my-atom (atom "a1"))

;; (add-watcher (var my-var) :send-off my-watcher my-watcher-action)
;; (add-watcher my-ref :send-off my-watcher my-watcher-action)
;; (add-watcher my-atom :send-off my-watcher my-watcher-action)

;; ; Change the root binding of the Var in two ways.
;; (def my-var "v2")
;; (alter-var-root (var my-var) (fn [curr-val] "v3"))

;; ; Change the Ref in two ways.
;; (dosync
;;   ; The next line only changes the in-transaction value
;;   ; so the watcher isn't notified.
;;   (ref-set my-ref "r2")
;;   ; When the transaction commits, the watcher is
;;   ; notified of one change this Ref ... the last one.
;;   (ref-set my-ref "r3"))
;; (dosync
;;   (alter my-ref (fn [_] "r4"))) ; And now one more.

;; ; Change the Atom in two ways.
;; (reset! my-atom "a2")
;; (compare-and-set! my-atom @my-atom "a3")

;; ; Wait for all the actions sent to the watcher Agent to complete.
;; (await my-watcher)

;; ; Output the number of changes to
;; ; each reference object that was watched.
;; (let [change-count-map @my-watcher]
;;   (println "my-var changes =" (change-count-map (var my-var))) ; -> 2
;;   (println "my-ref changes =" (change-count-map my-ref)) ; -> 2
;;   (println "my-atom changes =" (change-count-map my-atom))) ; -> 2

;; (shutdown-agents)
