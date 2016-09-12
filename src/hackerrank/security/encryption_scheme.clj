;; Security Encryption Scheme
;; https://www.hackerrank.com/challenges/security-encryption-scheme

(ns hackerrank.security.encryption-scheme
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:
; find factorial

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(defn encryption-scheme

  ([]
    (let [n (parseInt (read-line))]
        (factorial n)))

  ([input]
   (with-in-str input
     (encryption-scheme))))

;; uncomment for hackerrank:
;; (println (encryption-scheme))