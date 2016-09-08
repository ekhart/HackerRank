;; Security - Message Space and Ciphertext Space
;; https://www.hackerrank.com/challenges/security-message-space-and-ciphertext-space

(ns hackerrank.security.message-ciphertext-space
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

(defn message-ciphertext-space
  ([]
    (let [n (parseInt (read-line))]
        n))

  ([input]
   (with-in-str input
     (message-ciphertext-space))))
