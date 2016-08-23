(ns hackerrank.fp.pascal-triangle-test
  (:require [clojure.test :refer :all]
            [hackerrank.fp.pascal-triangle :refer :all]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.fp.pascal-triangle-test

(def test-string-input "4")

(defn is-equal [a b]
  (is (= a b)))

(deftest pascal-triangle-test

  (testing "parseInt"
    (is-equal (parseInt "1") 1))

  (testing "factorial"
    (is-equal (factorial 1) 1)
    (is-equal (factorial 2) 2)
    (is-equal (factorial 3) 6)
    (is-equal (factorial 4) 24))

  (testing "pascal-triangle"
    (is-equal (pascal-triangle test-string-input) 4))

)