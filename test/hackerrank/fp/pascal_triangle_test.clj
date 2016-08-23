(ns hackerrank.fp.pascal-triangle-test
  (:require [clojure.test :refer :all]
            [hackerrank.fp.pascal-triangle :refer :all]))

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

  (testing "pascal-triangle-triangle"
    (is (= (pascal-triangle-triangle 1) [[1]])))

  (testing "pascal-triangle"
    (is-equal (pascal-triangle test-string-input) 4))

)