;; Keyword Transposition Cipher
;; https://www.hackerrank.com/challenges/keyword-transposition-cipher

(ns hackerrank.security.keyword-transposition
  (:require [clojure.java.io :as io]
            [clojure.set :as set])
  (:use [clojure.string :only (split join trim) :as str]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:
;; The following keyword is :
;; HACKERRANK
;; The following is my message :
;; A EBYCGCQYEBP VGMDZCH FMG CBOGJVYEMB YXABSQ FMG XAOSCGGABS YCAH
;; v 1) find the alphabetical order for keyword and remove duplication...
;; [sport] ->[3,1,0,2,4]
;; v 2) make table for keyword. in the first row, add keyword..and keep putting alphabet, skipping when encountered with keyord(sport)... s,p,o,r,t
;; [sport,abcde,hijhk ... ]
;; 3) transpose for keyword. re-write for row-column swap...
;; [sah~~ , pbi~~ , ocj~~, ...]
;; 4) create decryption table(key-value pair) by putting together those of transposed array in 3) and the alphabetical order in 1)... in vice versa, value-key can play a role for encrytion...
;; ascii_letter       : abcdefg~~~
;; encrypted_letter   : ocj~~pbi~~
;; decryption table   : o:a, c:b,~~
;; encryption talbe   : a:o, b:c,~~
;; 5) execute and display decrypted output
;; +) have a fun with encrytion and confirm the encrytion with decryttion

(defn distinct-string [string]
  (str/join (distinct string)))

;; "abcdefghijklmnopqrstuvwxyz"
(def alphabet-seq (map char (range (int \a) (inc (int \z)))))
(def alphabet (str/join alphabet-seq))

(defn remove-chars [to from]
  (let [a (set (seq to))
        b (set (seq from))]
    (join (set/difference b a))))

(defn keyword-table [string]
  (let [s (distinct-string string)]
    (conj (map str/join (partition-all (count s) (remove-chars string alphabet-seq))) s)))

(defn transpose-table [table]
  (defn transpose-row [table i]
;;     (join (map #(if (< (count %) (count (first table))) "" (nth % i)) table)))
    (join (map #(if (>= i (count %)) "" (nth % i)) table)))

  (map #(transpose-row table %) (range (count (first table)))))

(defn keyword-transposition

  ([]
    (let [n (parseInt (read-line))]
        n))

  ([input]
   (with-in-str input
     (keyword-transposition))))

;; uncomment for hackerrank:
;; (println (keyword-transposition))




;; (map str/join (partition (count "sport") alphabet-seq))
;; (let [s (distinct-string "sport")]
;;     (conj (partition (count s) alphabet-seq)) s)

;; (remove-chars "sport" "abcdsport")
;; (seq "sport")
;; (seq "abcdsport")
;; (set/difference (set (seq "abcdsport")) (set (seq "sport")))
;; (str/join (set/difference (set (seq "abcdsport")) (set (seq "sport"))))

;;;; transpose-table
;; (def table ["safku" "pbglv" "ochmw" "rdinx" "tejqy"])
;; (def a (map first table))
;; (def b (map second table))
;; (def c (map #(nth % 2) table))
;; c
;; (map #(str %1 %2) a b)

;; (reduce str a)

;; (dotimes [i (count (first table))]
;;   (println (join (map #(nth % i) table))))

;; (defn transpose-row [table i]
;;   (join (map #(nth % i) table)))

;; (map #(transpose-row table %) (range (count (first table))))
