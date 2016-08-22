;; Rotate String
;; https://www.hackerrank.com/challenges/rotate-string

(ns hackerrank.fp.rotate-string
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))

(defn parseInt [n]
  (Integer/parseInt n))

(defn rotate-string
  ([]
   (let [t (parseInt (read-line))]
     t))

  ([string-input]
   (with-in-str string-input
     (rotate-string))))