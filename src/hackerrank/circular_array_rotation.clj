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


(defn circular-array-rotation [first-line second-line]
  (let [sl (get-numbers-in-line first-line)
        n (nth sl 0)
        k (nth sl 1)
        q (nth sl 2)
        array (get-numbers-in-line second-line)]

  (join " " [n k q])))