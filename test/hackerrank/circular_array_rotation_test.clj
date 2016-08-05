(ns hackerrank.circular-array-rotation-test
  (:require [clojure.test :refer :all]
            [hackerrank.circular-array-rotation :refer :all]))

; run test in cmd
; lein test hackerrank.circular-array-rotation-test
; run test in bash for git/cygwin
; lein.bat test hackerrank.circular-array-rotation-test

(def first-line "3 2 3")
(def second-line "1 2 3")
(def rest-of-lines "0\n1\n2")
(def sample-string-input "3 2 3\n1 2 3\n0\n1\n2")

(deftest circular-array-rotation-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

  (testing "splitted-line"
    (is (= (splitted-line first-line) ["3" "2" "3"])))

  (testing "get-numbers-in-line"
    (is (= (get-numbers-in-line first-line) [3 2 3]))
    (is (= (get-numbers-in-line second-line) [1 2 3])))

  (testing "circular-array-rotation"
    (is (= (circular-array-rotation sample-string-input) "3 2 3")))

  (testing "prompt-from-string"
    (is (= (prompt-from-string rest-of-lines) "answer 0")))

  (testing "rotate"
    (is (= (rotate-right [1 2 3]) [3 1 2]))
    (is (= (rotate-right [1 2 3] 2) [2 3 1])))

)
