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
;;     (println question)
;;     (println answer)
    answer))

(defn prompt-from-string [input]
  (with-in-str input
    (prompt "How old are you?")))

(defn rotate-right
  ([coll]
  (concat
    [(last coll)]
    (subvec coll 0 (dec (count coll)))))

  ([coll n]
   (loop [i 0
          temp-coll coll]
     (if (< i n)
       (recur (inc i) (rotate-right temp-coll))
       temp-coll))))

(defn circular-array-rotation
  ([]
   (let [sl (get-numbers-in-line (read-line))
        n (nth sl 0)
        k (nth sl 1)
        q (nth sl 2)
        a (get-numbers-in-line (read-line))
        m (lines q)]

     (println [n k q])
     (println a)
     (println m)

    (join " " [n k q])))

  ([string-input]
   (with-in-str string-input
     (circular-array-rotation))))
