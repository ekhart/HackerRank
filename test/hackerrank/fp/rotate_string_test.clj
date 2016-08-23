(ns hackerrank.fp.rotate-string-test
  (:require [clojure.test :refer :all]
            [hackerrank.fp.rotate-string :refer :all]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.fp.rotate-string-test

(def test-string-input "5\nabc\nabcde\nabab\naaa\nz")

(deftest rotate-string-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

  (testing "rotate"
    (is (= (rotate "abc" 1) "bca")))

  (testing "string rotation"
    (is (= (string-rotation "abc" 5) ["bca" "cab" "abc"]))
    (is (= (string-rotation "abcde" 5) ["bcdea" "cdeab" "deabc" "eabcd" "abcde"]))
    (is (= (string-rotation "abab" 5) ["baba" "abab" "baba" "abab"]))
    (is (= (string-rotation "aaa" 5) ["aaa" "aaa" "aaa"]))
    (is (= (string-rotation "z" 5) ["z"])))

  (testing "rotate-string-test"
    (is (= (rotate-string test-string-input) ["bca" "cab" "abc"])))

)
