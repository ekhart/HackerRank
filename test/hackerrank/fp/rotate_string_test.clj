(ns hackerrank.fp.rotate-string-test
  (:require [clojure.test :refer :all]
            [hackerrank.fp.rotate-string :refer :all]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.fp.rotate-string-test

(def sample-string-input "5\nabc\nabcde\nabab\naaa\nz")

(deftest rotate-string-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

  (testing "rotate-string-test"
    (is (= (rotate-string sample-string-input) 5)))

)