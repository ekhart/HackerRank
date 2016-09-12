;; Security Encryption Scheme
;; https://www.hackerrank.com/challenges/security-encryption-scheme

(ns hackerrank.security.encryption-scheme
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:
; find factorial

(defn encryption-scheme

  ([]
    (let [n (trim (read-line))]
        ))

  ([input]
   (with-in-str input
     (encryption-scheme))))
