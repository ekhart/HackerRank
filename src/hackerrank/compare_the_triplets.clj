(ns hackerrank.compare-the-triplets
	(:require [clojure.java.io :as io]
            [hackerrank.save-the-prisoner :refer :all])
  (:use [clojure.string :only (split join)]))

; https://www.hackerrank.com/challenges/compare-the-triplets


(def alice (atom 0))
(def bob (atom 0))

;; https://clojuredocs.org/clojure.core/swap!
;; https://clojuredocs.org/clojure.core/cond
(defn score [a b]
  (cond (= (compare a b) 1) (swap! alice inc)
        (= (compare a b) -1) (swap! bob inc)))

(let [a0_temp "5 6 7" ; (read-line)
      a0_t (split a0_temp #"\s+")
      a0 (parseInt (a0_t 0))
      a1 (parseInt (a0_t 1))
      a2 (parseInt (a0_t 2))

      b0_temp "3 6 10" ;(read-line)
      b0_t (split b0_temp #"\s+")
      b0 (parseInt (b0_t 0))
      b1 (parseInt (b0_t 1))
      b2 (parseInt (b0_t 2))]

  ;; https://clojuredocs.org/clojure.string/join
  (println (join " " [a0 a1 a2]))
  (println (join " " [b0 b1 b2]))

  (score a0 b0)
  (score a1 b1)
  (score a2 b2)

  (println @alice " " @bob)
)
