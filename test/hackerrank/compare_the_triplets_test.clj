(ns hackerrank.compare-the-triplets-test
  (:require [clojure.test :refer :all]
;;             [hackerrank.save-the-prisoner :refer :all]
            [hackerrank.compare-the-triplets :refer :all]))

; run test
; lein test hackerrank.compare-the-triplets-test
; lein.bat test hackerrank.compare-the-triplets-test

(deftest parseInt-test
  (testing "parseInt"
    (is (= (parseInt "1") 1))))

(deftest compare-test
  (testing "compare"
    (is (= (compare 5 3) 1))
    (is (= (compare 6 6) 0))
    (is (= (compare 7 10) -1)))

  (testing "compare-triplets"
    (is (compare-triplets "5 6 7" "3 6 10") "1 1")))
