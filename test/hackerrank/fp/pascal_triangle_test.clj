(ns hackerrank.fp.pascal-triangle-test
  (:require [clojure.test :refer :all]
            [hackerrank.fp.pascal-triangle :refer :all]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.fp.pascal-triangle-test

(def test-string-input "5\nabc\nabcde\nabab\naaa\nz")

(deftest pascal-triangle-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

)