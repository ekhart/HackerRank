(ns hackerrank.time-conversion-test
  (:require [clojure.test :refer :all]
            [hackerrank.time-conversion :refer :all]))

; run test in cmd
; lein test hackerrank.time-conversion-test
; run test in bash for git
; lein.bat test hackerrank.time-conversion-test

(deftest time-conversion-test
  (testing "time-conversion"
    (is (= (time-conversion "07:05:45PM") "19:05:45"))
    (is (= (time-conversion "12:05:45AM") "00:05:45"))
    (is (= (time-conversion "12:05:45PM") "12:05:45"))
  )
)
