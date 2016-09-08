(ns hackerrank.security.message-ciphertext-space-test
  (:require [clojure.test :refer :all]
            [hackerrank.security.message-ciphertext-space :refer :all])
  (:use [clojure.string :only (split join)]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.security.message-ciphertext-space-test

(def input "982")

(seq "0123456789")
(seq "9012345678")

(deftest message-ciphertext-space-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))



  (testing "message-ciphertext-space"
    (is (= (message-ciphertext-space input) "093")))
)

