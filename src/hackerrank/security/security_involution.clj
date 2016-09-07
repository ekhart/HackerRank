;; Security Involution
;; https://www.hackerrank.com/challenges/security-involution/forum

(ns hackerrank.security.security-involution
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(def input "2\n2 1")

(defn parseInt [string]
  (Integer/parseInt string))

(with-in-str input
  (let [n (parseInt (read-line))
        numbers (concat [0](map parseInt (split (read-line) #" ")))
        numbers2 (for [x numbers] (nth numbers (dec x)))]

      n
      numbers
;;       (println numbers2)

      (doseq [i (range 1 (inc n))]
;;         (println i (nth numbers i))
        (println (nth numbers (nth numbers i))))))