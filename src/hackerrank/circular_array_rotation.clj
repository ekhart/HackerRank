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

(defn list-append [coll item]
  (concat coll (list item)))

(defn lines [n]
  (loop [i 0
    	coll (list)]
    (if (< i n)
    	(recur (inc i)
    			(list-append coll (read-line)))
    	coll)))

(defn prompt [question]
  (let [answer (str "answer " (read-line))]
    (println question)
    (println answer)
    answer))

(defn prompt-from-string [input]
  (with-in-str input
    (prompt "How old are you?")))


(defn circular-array-rotation [first-line second-line]
  (let [sl (get-numbers-in-line first-line)
        n (nth sl 0)
        k (nth sl 1)
        q (nth sl 2)
        array (get-numbers-in-line second-line)]

    (join " " [n k q])))

;; (defn circular-array-rotation-from-string-input []
