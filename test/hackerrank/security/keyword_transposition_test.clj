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
(def table-transposed ["safkuz" "pbglv" "ochmw" "rdinx" "tejqy"])

(def hackerrank-table ["secrt" "abdfg" "hijkl" "mnopq" "uvwxy" "z"])
(def hackerrank-table-transposed ["sahmuz" "ebinv" "cdjow" "rfkpx" "tglqy"])

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
    (is (= (remove-chars "sport" alphabet-seq) "abcdefghijklmnquvwxyz"))
    (is (= (remove-chars "secret" alphabet-seq) "abdfghijklmnopquvwxyz")))

  (testing "keyword-table"
    (is (= (keyword-table "sport") table))
    (is (= (keyword-table "secret") hackerrank-table)))

  (testing "transpose-table"
    (is (= (transpose-table table) table-transposed))
    (is (= (transpose-table hackerrank-table) ["sahmuz" "ebinv" "cdjow" "rfkpx" "tglqy"])))

  (testing "sort-table"
    (is (= (sort-table table-transposed "sport") ["ochmw" "pbglv" "rdinx" "safkuz" "tejqy"]))
    (is (= (sort-table hackerrank-table-transposed "secret") ["cdjow" "ebinv" "rfkpx" "sahmuz" "tglqy"])))

  (testing "keyword-transposition"
    (is (= (keyword-transposition test-input) 2)))

)
