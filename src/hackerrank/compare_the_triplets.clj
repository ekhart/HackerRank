(ns hackerrank.compare-the-triplets
	(:require [clojure.java.io :as io]
            [hackerrank.save-the-prisoner :refer :all])
  (:use [clojure.string :only (split)]))

; https://www.hackerrank.com/challenges/compare-the-triplets

(let [a0_temp "5 6 7" ; (read-line)
      a0_t (split a0_temp #"\s+")
      a0 (Integer/parseInt (a0_t 0))
      a1 (Integer/parseInt (a0_t 1))
      a2 (Integer/parseInt (a0_t 2))

      b0_temp "3 6 10" ;(read-line)
      b0_t (split b0_temp #"\s+")
      b0 (Integer/parseInt (b0_t 0))
      b1 (Integer/parseInt (b0_t 1))
      b2 (Integer/parseInt (b0_t 2))]
)
