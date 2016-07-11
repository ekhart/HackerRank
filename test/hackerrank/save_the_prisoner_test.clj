(ns hackerrank.save-the-prisoner-test
  (:require [clojure.test :refer :all]
            [hackerrank.save-the-prisoner :refer :all]))

(deftest parseInt-test
  (testing "parseInt"
    (is (= (parseInt "1") 1))))