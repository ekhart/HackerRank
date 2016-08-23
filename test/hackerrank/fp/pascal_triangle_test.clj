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
    (is (= (factorial 1) 1)))
;;     (is (= (

  (testing "pascal-triangle"
    (is (= (pascal-triangle test-string-input) 4)))

)