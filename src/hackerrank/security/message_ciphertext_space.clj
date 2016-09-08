;; Security - Message Space and Ciphertext Space
;; https://www.hackerrank.com/challenges/security-message-space-and-ciphertext-space

(ns hackerrank.security.message-ciphertext-space
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:
;; map "[0-9]" ot "[1-90]
;; ("0", "1", ..., "9") -> ("1", "2", ..., "0")
;; ->
(def before (seq "0123456789"))
(def after (seq "1234567890"))
;; zip colls to dict (key value)
;; (map #(println %1 %2) before after)

;; http://stackoverflow.com/questions/2588227/is-there-an-equivalent-for-the-zip-function-in-clojure-core-or-contrib
;; http://stackoverflow.com/questions/5088803/in-clojure-is-there-an-easy-way-to-convert-between-list-types
(def zipped (into {} (map hash-map before after)))

;; (nth zipped 1)

;; (into {} zipped)
zipped

;; each element of input string map using zipped to coresponding char
(map zipped (seq "982"))

;; joins chars - get string
(apply str (map zipped (seq "982")))

(defn message-ciphertext-space

  ([]
    (def before (seq "0123456789"))
    (def after (seq "1234567890"))
    (def zipped (into {} (map hash-map before after)))

   (let [n (trim (read-line))]
        (apply str (map zipped (seq "982")))))

  ([input]
   (with-in-str input
     (message-ciphertext-space))))
