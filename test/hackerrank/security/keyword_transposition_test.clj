(ns hackerrank.security.keyword-transposition-test
  (:require [clojure.test :refer :all]
            [hackerrank.security.keyword-transposition :refer :all]))

; run test
; in cmd:
; lein test hackerrank.security.keyword-transposition-test
; in cygwin:
; lein.bat test hackerrank.security.keyword-transposition-test

(def test-input "2
SPORT
LDXTW KXDTL NBSFX BFOII LNBHG ODDWN BWK
SECRET
JHQSU XFXBQ")

(deftest parseInt-test
  (testing "parseInt"
    (is (= (parseInt "1") 1))))

(deftest keyword-transposition-test

  (testing "distinct"
    (is (= (distinct-string "aabc") "abc")))

  (testing "keyword-transposition"
    (is (= (keyword-transposition test-input) 2)))

)
