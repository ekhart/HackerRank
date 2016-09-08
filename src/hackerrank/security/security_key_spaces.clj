;; Security Key Spaces
;; https://www.hackerrank.com/challenges/security-key-spaces

(ns hackerrank.security.key-spaces
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:

(defn key-spaces
  ([]
    (def before (seq "0123456789"))
    (def after (seq "1234567890"))
    (def zipped (into {} (map hash-map before after)))
    (let [message (trim (read-line))
          e (parseInt (read-line))]
      (apply str (map zipped (seq message)))))

  ([input]
   (with-in-str input
     (key-spaces))))

(key-spaces "391\n2")