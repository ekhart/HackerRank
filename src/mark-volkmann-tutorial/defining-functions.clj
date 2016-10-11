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
(filter (fn [year] (even? year)) years)
(filter #(even? %) years)
;; my experiments
(filter (partial even?) years)
(filter even? years)