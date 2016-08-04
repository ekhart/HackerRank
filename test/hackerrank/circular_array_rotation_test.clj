(ns hackerrank.circular-array-rotation-test
  (:require [clojure.test :refer :all]
            [hackerrank.circular-array-rotation :refer :all]))

; run test in cmd
; lein test hackerrank.circular-array-rotation-test
; run test in bash for git/cygwin
; lein.bat test hackerrank.circular-array-rotation-test

(deftest circular-array-rotation-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

  (testing "splitted-line"
    (is (= (splitted-line "3 2 3") ["3" "2" "3"])))

  (testing "get-numbers-in-line"
    (is (= (get-numbers-in-line "3 2 3") [3 2 3])))

  (testing "circular-array-rotation"
    (is (= (circular-array-rotation "3 2 3") "3 2 3"))
  )
)
