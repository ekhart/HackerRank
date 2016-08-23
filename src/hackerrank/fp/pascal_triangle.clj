;; Pascal's Triangle
;; https://www.hackerrank.com/challenges/pascals-triangle

(ns hackerrank.fp.pascal-triangle
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))


(defn parseInt [n]
  (Integer/parseInt n))

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(defn pascal-triangle-value [n r]
  (/
    (factorial n)
    (*
      (factorial r)
      (factorial (- n r)))))

(defn pascal-triangle-row [r]
  (map #(pascal-triangle-value r %) (range (inc r))))

(defn pascal-triangle-triangle [n]
  (map pascal-triangle-row (range n)))

(defn pascal-triangle-print [coll]
  (reduce #(str (join " " %) "\n") coll))

(defn pascal-triangle
  ([]
   (let [k (parseInt (read-line))]

     ))

  ([string-input]
   (with-in-str string-input
     (pascal-triangle))))

;; uncomment after copy-paste to hackerrank buffer
;; (pascal-triangle)
