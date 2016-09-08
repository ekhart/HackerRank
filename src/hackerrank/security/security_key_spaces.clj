;; Security Key Spaces
;; https://www.hackerrank.com/challenges/security-key-spaces

(ns hackerrank.security.key-spaces
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [string]
  (Integer/parseInt string))

;; solution idea:
;; shift after n times

(defn key-spaces
  ([]
   (let [message (trim (read-line))
         e (parseInt (read-line))

         before (seq "0123456789")
         after (take (count before) (drop e (cycle before)))
         zipped (into {} (map hash-map before after))]

      (join (map zipped (seq message)))))

  ([input]
   (with-in-str input
     (key-spaces))))

(key-spaces "391\n3")