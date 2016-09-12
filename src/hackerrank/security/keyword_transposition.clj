;; Keyword Transposition Cipher
;; https://www.hackerrank.com/challenges/keyword-transposition-cipher

(ns hackerrank.security.keyword-transposition
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:

(defn keyword-transposition

  ([]
    (let [n (parseInt (read-line))]
        (factorial n)))

  ([input]
   (with-in-str input
     (keyword-transposition))))

;; uncomment for hackerrank:
;; (println (keyword-transposition))