(ns hackerrank.even-tree-test
  (:require [clojure.test :refer :all]
            [hackerrank.even-tree :refer :all])
  (:use [clojure.string :only (split join)]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.even-tree-test

(def test-string-input "10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8")

(deftest even-tree-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

  (testing "even-tree"
    (is (= (even-tree test-string-input) nil)))

)
