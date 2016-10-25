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