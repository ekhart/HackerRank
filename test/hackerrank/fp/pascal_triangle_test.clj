(ns hackerrank.fp.pascal-triangle-test
  (:require [clojure.test :refer :all]
            [hackerrank.fp.pascal-triangle :refer :all]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.fp.pascal-triangle-test

(def test-string-input "4")

(deftest pascal-triangle-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

  (testing "pascal-triangle"
    (is (= (pascal-triangle test-string-input) 4)))

)