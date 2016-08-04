;; Circular Array Rotation
;; https://www.hackerrank.com/challenges/circular-array-rotation

(ns hackerrank.circular-array-rotation
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))

(defn parseInt [n]
  (Integer/parseInt n))

(defn splitted-line [line]
  (split line #" "))

(defn get-numbers-in-line [line]
  (map parseInt (splitted-line line)))


(defn circular-array-rotation [input]
  (let [sl (splitted-line input)
        n (sl 0)
        k (sl 1)
        q (sl 2)]

  (join " " [n k q])))