;; Automated Testing
;; http://java.ociweb.com/mark/clojure/article.html#Testing

(use 'clojure.test)

; Test can be written in separate functions.
(deftest add-test
  ; The "is" macro takes a predicate, arguments to it,
  ; and an optional message.
  (is (= 4 (+ 2 2)))
  (is (= 2 (+ 2 0)) "adding zero doesn't change value"))

(deftest reverse-test
  (is (= [3 2 1] (reverse [1 2 3]))))

; Tests can verify that a specific exception is thrown.
(deftest divistion-test
  (is (thrown? ArithmeticException (/ 3 0))))

; The with-test macro can be used to add tests
; to the functions that test as metadata.
(with-test
  (defn my-add [a b] (+ a b))
  (is (= 4 (my-add 2 2)))
  (is (= 2 (my-add 2 0)) "adding zero doesn't change value"))

; The "are" macro takes a predicate template and
; multiple sets of arguments to it, but no message.
; Each set of arguments are substituted one at a time
; into the predicate template and evaluated.
(deftest multiplication
  (are [a b result]
       (= (* a b) result) ; a template
       1 1 1,
       1 2 2,
       2 3 6))

; Run all the tests in the current namespace.
; This includes tests that were added as function metadata using with-test.
; Other namespaces can be specified as quoted arguments
(run-tests)

; limit *stack-trace-depth*

; *load-tests* - set to false to avoid compiling test code when in production

; assert macro - in, out function conditions
(def dow 10000)
(assert (>= dow 7000))

; fixture - wraps test methods
;; (defn fixture-name [test-function]
;;   ; Perform setup here.
;;   (test-function)
;;   ; Perform teardown here.
;; )

; register fixtures to rap each method
;; (use-fixtures :each fixture-1 fixture-2 ...) ; one function
;; (use-fixtures :once fixture-1 fixture-2 ...) ; all functions
; src, test directory -> enter "ant test"