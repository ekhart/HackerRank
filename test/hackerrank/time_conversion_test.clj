(ns hackerrank.time-conversion-test
  (:require [clojure.test :refer :all]
            [hackerrank.time-conversion :refer :all]))

; run test in cmd
; lein test hackerrank.time-conversion-test
; run test in bash for git
; lein.bat test hackerrank.time-conversion-test

(deftest time-conversion-test
  (testing "time-conversion"
    (is (= (time-conversion "asdf") "asdf"))))
