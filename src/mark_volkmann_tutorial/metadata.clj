;; Metadata
;; http://java.ociweb.com/mark/clojure/article.html#Metadata

(defstruct card-struct :rank :suit)

(def card1 (struct card-struct :king :club))
(def card2 (struct card-struct :king :club))

;; (println (== card1 card2))    ; same identity? -> false
; raise error: java.lang.ClassCastException: clojure.lang.PersistentStructMap cannot be cast to java.lang.Number Numbers.java:208 clojure.lang.Numbers.equiv
(println (= card1 card2))     ; same value? -> true

(def card2 ^{:bent true} card2)           ; adds metadata at read-time
(def card2 (with-meta card2 {:bent true})) ; adds metadata at run-time

(println (meta card1)) ; -> nil
(println (meta card2)) ; -> {:bent true}
(println (= card1 card2)) ; still samve value despite metadata diff. -> true


; :private metadata - access restricted in namespace
; :doc - documentation string
; :test - is it test function?
; :tag - type hint -> improve performance, *warn-on-reflection*

; automatically attached
; :file - for Var
; :line - where defined
; :name - symbol
; :ns - namespace
; :macro - boolean
; :arglist - list of vectors of arguments

(meta (var reverse))

; (source reverse) ; don't work in LightTable, work in REPL - retrive code for function or macro