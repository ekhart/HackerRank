(ns hackerrank.fp.pascal-triangle-test
  (:require [clojure.test :refer :all]
            [hackerrank.fp.pascal-triangle :refer :all])
  (:use [clojure.string :only (split join)]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.fp.pascal-triangle-test

(def test-string-input "4")

(defn is-equal [a b]
  (is (= a b)))       ; but this dont show proper file line


(deftest pascal-triangle-test

  (testing "parseInt"
    (is-equal (parseInt "1") 1))

  (testing "factorial"
    (is-equal (factorial 1) 1)
    (is-equal (factorial 2) 2)
    (is-equal (factorial 3) 6)
    (is-equal (factorial 4) 24))

  (testing "pascal-triangle-value"
    (is-equal (pascal-triangle-value 0 0) 1)
    (is-equal (pascal-triangle-value 1 0) 1)
    (is-equal (pascal-triangle-value 1 1) 1)
    (is-equal (pascal-triangle-value 2 0) 1)
    (is-equal (pascal-triangle-value 2 1) 2)
    (is-equal (pascal-triangle-value 2 2) 1))

  (testing "pascal-triangle-row"
    (is (= (pascal-triangle-row 0) [1]))
    (is (= (pascal-triangle-row 1) [1 1]))
    (is (= (pascal-triangle-row 2) [1 2 1]))
    (is (= (pascal-triangle-row 3) [1 3 3 1])))

  (testing "pascal-triangle-triangle"
    (is (= (pascal-triangle-triangle 1) [[1]]))
    (is (= (pascal-triangle-triangle 2) [[1] [1 1]]))
    (is (= (pascal-triangle-triangle 3) [[1] [1 1] [1 2 1]]))
    (is (= (pascal-triangle-triangle 4) [[1] [1 1] [1 2 1] [1 3 3 1]])))

  (testing "list"
    (is (= (list 1) [1]))
    (is (= (list (list 1)) [[1]])))

  (testing "reduce"
    (is (= (reduce #(str (join " " %1) "\n" (join " " %2) "\n") [[1 2] [3 4]]) "1 2\n3 4\n")))

  (testing "pascal-triangle-print"
    (is (= (pascal-triangle-print [[1]]) "1"))
    (is (= (pascal-triangle-print [[1] [1 1]]) "1\n1 1"))
    (is (= (pascal-triangle-print [[1] [1 1] [1 2 1]]) "1\n1 1\n1 2 1"))
    (is (= (pascal-triangle-print [[1] [1 1] [1 2 1] [1 3 3 1]]) "1\n1 1\n1 2 1\n1 3 3 1")))


  (testing "pascal-triangle"
    (is-equal (pascal-triangle test-string-input) nil))

)
