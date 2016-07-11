(ns hackerrank.save-the-prisoner-test
  (:require [clojure.test :refer :all]
            [hackerrank.save-the-prisoner :refer :all]))

(deftest parseInt-test
  (testing "parseInt"
    (is (= (parseInt "1") 1))))

(deftest read-line-test
	(is (= (read-line) "1")))

(deftest get-current-path-test
	(is (= (get-current-path) "H:\\github\\hackerrank")))

(deftest get-test-case-number-test
	(is (= (get-test-case-number) 1)))