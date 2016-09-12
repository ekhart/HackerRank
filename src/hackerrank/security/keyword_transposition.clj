;; Keyword Transposition Cipher
;; https://www.hackerrank.com/challenges/keyword-transposition-cipher

(ns hackerrank.security.keyword-transposition
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:
;; The following keyword is :
;; HACKERRANK
;; The following is my message :
;; A EBYCGCQYEBP VGMDZCH FMG CBOGJVYEMB YXABSQ FMG XAOSCGGABS YCAH
;; 1) find the alphabetical order for keyword and remove duplication...
;; [sport] ->[3,1,0,2,4]
;; 2) make table for keyword. in the first row, add keyword..and keep putting alphabet, skipping when encountered with keyord(sport)... s,p,o,r,t
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
  (join (distinct string)))

;; "abcdefghijklmnopqrstuvwxyz"
(def alphabet (join (map char (range (int \a) (inc (int \z))))))

(defn keyword-transposition

  ([]
    (let [n (parseInt (read-line))]
        n))

  ([input]
   (with-in-str input
     (keyword-transposition))))

;; uncomment for hackerrank:
;; (println (keyword-transposition))