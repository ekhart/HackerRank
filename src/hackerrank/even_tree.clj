;; Even Tree
;; https://www.hackerrank.com/challenges/even-tree

(ns hackerrank.even-tree
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [n]
  (Integer/parseInt n))

(defn even-tree
  ([])

  ([string-input]
   (with-in-str string-input
     (even-tree))))

;; uncomment after copy-paste to hackerrank buffer
;; (even-tree)
