;; Defining Functions
;; http://java.ociweb.com/mark/clojure/article.html#DefiningFunctions

(defn parting                  ; is private - visible only in defined namespace
  "returns a String parting"   ; optional doc string - displayed by (doc fun) macro
  [name]
  (str "Goodbye, " name))

(println (parting "Mark"))

; function must be before use
; forward declaration
(declare function)

; optional parameters in list
(defn power [base & exponents]
  ; Using java.lang.Math static method pow.
  (reduce #(Math/pow %1 %2) base exponents))

(power 2 3 4)

; function overloading based on parameter arity
(defn parting
  "returns a String parting in a given language"
  ([] (parting "World"))
  ([name] (parting name "en"))
  ([name language]
   ; condp is similar to a case statement in other languages.
   ; it is described in more detail later.
   ; is is used here to take different actions based on wheter the
   ; parameter "language" is set to "en", "es" or something else.
   (condp = language
     "en" (str "Goodbye, " name)
     "es" (str "Adios, " name)
     (throw (IllegalArgumentException.
              (str "unsupported language " language))))))

(parting)
(parting "Mark")
(parting "Mark" "es")
;; (parting "Mark" "xy")


; anonymous fun - short, in one place higher-order function arguments
(def years [1940 1944 1961 1985 1987])
(filter (fn [year] (even? year)) years)   ; fn body can contain many forms
(filter #(even? %) years)                 ; #() can contain only one form, or use #(do ...), % - argument
                                          ; %1, %2, ... more
;; my experiments
(filter (partial even?) years)
(filter even? years)

(defn pair-test [test-fn n1 n2]
  (if (test-fn n1 n2) "pass" "fail"))

; Use a test-fn that determines wheter
; the sum of its two arguments is an even number.
(pair-test #(even? (+ %1 %2)) 3 5)


; overload based on type in Java, based on arity in Clojure
; but defmulti & defmethod can do this
; :default disptach
(defmulti what-am-i class) ; class is the disptach function
; (defmethod method-name dispatch-value [args-list] body)
(defmethod what-am-i Number [arg] (println arg "is a Number"))
(defmethod what-am-i String [arg] (println arg "is a String"))
(defmethod what-am-i :default [arg] (println arg "is something else"))
(what-am-i 19)
(what-am-i "Hello")
(what-am-i true)
; custom dispatch function

; _ (underscore) as placeholder, ommited value - destructing
(defn callback1 [a b c] (+ a b c))
(defn callback2 [a _ c] (+ a c))
(defn caller [callback value]
  (callback (+ value 1) (+ value 2) (+ value 3)))
(caller callback1 10)
(caller callback2 10)

; complement - returns fun oposite to given
(defn teenager? [age] (and (>= age 13) (< age 20)))
; (defn not-teen? (complement teenager?)) ; java.lang.IllegalArgumentException: Parameter declaration "complement" should be a vector
(def not-teen? (complement teenager?))
(not-teen? 47)

; comp - combine functions, call order - from right to left
(defn times2 [n] (* n 2))
(defn minus3 [n] (- n 3))
; Note the use of def instead of defn because comp returns
; a function that is then bound to "my-composition".
(def my-composition (comp minus3 times2))
(my-composition 4)

; partial - curring (partial aplication) -> returns functions so alse use def instead of defn
(def times2 (partial * 2))
(times2 3 4)

; use of map & partial
; defn- : not public https://clojuredocs.org/clojure.core/defn-
(defn- polymonial
  "computes the value of a polymonial
  with the given coefficients for a given value x"
  [coefs x]
  ; For example, if coefs contains 3 values then exponents is (2 1 0).
  (let [exponents (reverse (range (count coefs)))]
    ; Multiply each coefficient by x raised to the corresponding exponent
    ; and sum those results.
    ; coefs go into %1 and exponents go into %2.
    (apply + (map #(* %1 (Math/pow x %2)) coefs exponents))))

(defn- derivative
  "computes the value of the derivative of a polynomial
   with the given coefficients for a given value x"
  [coefs x]
  ; The coefficients of the derivative of a polymonial
  ; multiplying all but the last coefficient by its corresponding exponent.
  ; The extra exponent will be ignored.
  (let [exponents (reverse (range (count coefs)))
        derivative-coefs (map #(* %1 %2) (butlast coefs) exponents)]
    (polymonial derivative-coefs x)))

(def f (partial polymonial [2 1 3])) ; 2x^2 + x + 3
(def f-prime (partial derivative [2 1 3])) ; 4x + 1

(defn- polymonial
  "computes the value of a polymonial
  with the given coefficients for a given value x"
  [coefs x]
  (reduce #(+ (* x %1) %2) coefs))

(println "f(2) =" (f 2))
(println "f'(2) =" (f-prime 2))

; memoize - function memoization (caching) - better performance, but requires memory
; time - eval expr & return print elapsed time for its
(def memo-f (memoize f))

(println "printing call")
(time (f 2))

(println "without memoization")
; Note use of an underscore for the binding thath isn't used.
(dotimes [_ 3] (time (f 2)))

(println "with memoization")
(dotimes [_ 3] (time (memo-f 2)))


