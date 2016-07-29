(ns hackerrank.compare-the-triplets
	(:require [clojure.java.io :as io]
            [hackerrank.save-the-prisoner :refer :all])
  (:use [clojure.string :only (split join)]))

; https://www.hackerrank.com/challenges/compare-the-triplets


(def max-points 100)
(def alice (atom 0))
(def bob (atom 0))

;; https://clojuredocs.org/clojure.core/swap!
;; https://clojuredocs.org/clojure.core/cond
(defn score [a b]
  (cond (and (> (compare a b) 0) (< @alice max-points)) (swap! alice inc)
        (and (< (compare a b) 0) (< @bob max-points)) (swap! bob inc)))

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

  ;; https://clojuredocs.org/clojure.string/join
  (println (join " " [a0 a1 a2]))
  (println (join " " [b0 b1 b2]))

  (score a0 b0)
  (score a1 b1)
  (score a2 b2)

  (println @alice @bob)
)

;; 2016-07-29 17:04
;; 1/7 points
;; o think of others test cases
;; o make it more testable
