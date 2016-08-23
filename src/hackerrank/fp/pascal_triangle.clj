;; Pascal's Triangle
;; https://www.hackerrank.com/challenges/pascals-triangle

(ns hackerrank.fp.pascal-triangle
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))


(defn parseInt [n]
  (Integer/parseInt n))

(defn pascal-triangle
  ([]
   (let [k (parseInt (read-line))]
     k))

  ([string-input]
   (with-in-str string-input
     (pascal-triangle))))

;; uncomment after copy-paste to hackerrank buffer
;; (pascal-triangle)
