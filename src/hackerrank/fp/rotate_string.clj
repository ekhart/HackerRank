;; Rotate String
;; https://www.hackerrank.com/challenges/rotate-string

(ns hackerrank.fp.rotate-string
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))

(defn parseInt [n]
  (Integer/parseInt n))

(defn list-append [coll item]
  (concat coll (list item)))

(defn lines [n]
  (loop [i 0
    	coll (list)]
    (if (< i n)
    	(recur (inc i)
    			(list-append coll (read-line)))
    	coll)))

(defn rotate [string n]
  (join
    (lazy-cat
      (drop n string)
      (take n string))))

(defn string-rotation [string n]
  (map
    #(rotate string %)
    (range 1 (inc (count string)))))

(defn rotate-string
  ([]
   (let [t (parseInt (read-line))
         strings (lines t)]

     (doseq [string strings]
       (println (join " " (string-rotation string t))))

     (map #(string-rotation % t) strings)))

  ([string-input]
   (with-in-str string-input
     (rotate-string))))

;; uncomment after copy-paste to hackerrank buffer
;; (rotate-string)

;; 2016-08-23 14:20 working solution 1/12 points ;d
