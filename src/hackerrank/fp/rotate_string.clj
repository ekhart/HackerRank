;; Rotate String
;; https://www.hackerrank.com/challenges/rotate-string

(ns hackerrank.fp.rotate-string
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))

(defn parseInt [n]
  (Integer/parseInt n))

(defn rotate-string
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
     (rotate-string))))