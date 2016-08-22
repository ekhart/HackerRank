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

(defn rotate-string
  ([]
   (let [t (parseInt (read-line))
         strings (lines t)]
     strings))

  ([string-input]
   (with-in-str string-input
     (rotate-string))))