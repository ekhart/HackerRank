;; run in LightTable to instarepl
;; crtl+d / crlt+shift+d - see / search finction docs

;;;; 2.1 Forms
;;; Numeric Types
42
(< 5 2)
[1 2 3]
(+ 1 2)
(concat [1 2] [3 4])
(+ 1 2 3)
(+)
;; (-) error
(* 3 10 10)

(> 5 2)
(>= 5 2 1)

(class (/ 200 7))

(quot 22 7)
(rem 22 7)

(+ 1 (/ 0.000001 10000000000000000))
(+ 1 (/ 0.000001M 10000000000000000))   ;; BigDecimal
(* 1000N 1000 1000 1000 1000)   ;; BigInteger


;;; Symbols
"This is a\nmultiline string"
"This is also
multiline string"

(.toUpperCase "hello")   ;; calling Java
(str 1 nil)   ;; toString for Clojure

(str \h \e \y \space \y \o \u)

(Character/toUpperCase \a)

(interleave "abc" "def")
(str (interleave "abc" "def")) ;; "clojure.lang.LazySeq@e01b91ca"
;; solution
(apply str (interleave "abc" "def"))
(apply str (take-nth 2 "abcd"))

;; Booleans and nil
; empty list is true
(if () "we are in clojure" "we're in common lisp") ;; "we are in clojure"
; zero is also true
(if 0 "zero is true" "zero is false") ;; "zero is true"

; predicate
(true? true)
(false? true)
(nil? 0)
(zero? 0)

;; (find-doc #"\?$")   ;; find all predicates



;;; Maps
; (def invetors {"Lisp" "McCarthy" "Clojure" "Hickey"})
;; (def invetors {"Lisp" "McCarthy", "Clojure" "Hickey"})   ;; can use commas
;; ; map is function
;; (invetors "Lisp") ;; "McCarthy" == (get invetors "Lisp")
;; (invetors "a")   ; nil
;; (get invetors "a" "dunno") ; "dunno"

;; keyword
:key

(def invetors {:Lisp "McCarthy" :Clojure "Hickey"})
;; keywords are also functions
(invetors :Lisp) ;; == (:Lisp invetors)


(defrecord Book [title author])
(->Book "title" "author")   ; create record in clojure
;; ==
(Book. "alternative" "way of create record")
;; longer way, also work
(def c #user.Book{:title "a" :author "b"})

(def b (->Book "a" "b"))
;; record behave like map
(:title b)