;; Even Tree
;; https://www.hackerrank.com/challenges/even-tree

(ns hackerrank.even-tree
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [n]
  (Integer/parseInt n))


(defn numbers [string]
  (map parseInt (split string #" ")))


(defn even-tree
  ([]
   (let [first-line-numbers (numbers (read-line))
         n (nth first-line-numbers 0)]
     (println n)
     n))

  ([string-input]
   (with-in-str string-input
     (even-tree))))

;; uncomment after copy-paste to hackerrank buffer
;; (even-tree)
