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


