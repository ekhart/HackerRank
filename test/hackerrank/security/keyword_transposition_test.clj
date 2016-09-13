(ns hackerrank.security.keyword-transposition-test
  (:require [clojure.test :refer :all]
            [hackerrank.security.keyword-transposition :refer :all]))

; run test
; in cmd:
; lein test hackerrank.security.keyword-transposition-test
; in cygwin:
; lein.bat test hackerrank.security.keyword-transposition-test
; !l -> run last command starting with l (lein ... in this case)

(def test-input "2
SPORT
LDXTW KXDTL NBSFX BFOII LNBHG ODDWN BWK
SECRET
JHQSU XFXBQ")

(def table ["sport", "abcde", "fghij", "klmnq", "uvwxy", "z"])

(deftest parseInt-test
  (testing "parseInt"
    (is (= (parseInt "1") 1))))

(deftest keyword-transposition-test

  (testing "distinct"
    (is (= (distinct-string "aabc") "abc"))
    (is (= (distinct-string "SECRET") "SECRT")))

  (testing "alphabet"
    (is (= alphabet "abcdefghijklmnopqrstuvwxyz")))

  (testing "remove-chars"
    (is (= (remove-chars "sport" alphabet-seq) "abcdefghijklmnquvwxyz")))

  (testing "keyword-table"
    (is (= (keyword-table "sport") table)))

  (testing "transpose-table"
    (is (= (transpose-table table) ["safku" "pbglv" "ochmw" "rdinx" "tejqy"])))

  (testing "keyword-transposition"
    (is (= (keyword-transposition test-input) 2)))

)
