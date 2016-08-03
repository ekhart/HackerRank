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
    (is (= (compare-triplets "5 6 7" "5 6 7") "0 0"))

    (is (= (compare-triplets "5 6 7" "3 6 10") "1 1"))

    (is (= (compare-triplets "1 100 7" "1 100 8") "0 1"))
    (is (= (compare-triplets "1 100 7" "1 100 6") "1 0"))

    (is (= (compare-triplets "1 100 7" "1 101 8") "0 2"))
    (is (= (compare-triplets "1 100 7" "1 99 6") "2 0"))

    (is (= (compare-triplets "1 100 7" "0 101 8") "1 2"))
    (is (= (compare-triplets "1 100 7" "2 99 6") "2 1"))

    (is (= (compare-triplets "5 6 7" "1 2 3") "3 0"))
    (is (= (compare-triplets "1 2 3" "5 6 7") "0 3"))

    (is (not= (compare-triplets "5 6 7" "5 6 7") "1 1"))
    (is (not= (compare-triplets "5 6 7" "1 2 3") "0 3"))
))
