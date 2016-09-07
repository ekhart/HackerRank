;; Security Permutations
;; https://www.hackerrank.com/challenges/security-tutorial-permutations/forum

(ns hackerrank.security.security-permutations
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(def input "3\n2 3 1")

(defn parseInt [string]
  (Integer/parseInt string))

(with-in-str input
  (let [n (parseInt (read-line))
        numbers (concat [0](map parseInt (split (read-line) #" ")))]

      (doseq [i (range 1 (inc n))]
;;         (println i (nth numbers i))
        (println (nth numbers (nth numbers i))))))
