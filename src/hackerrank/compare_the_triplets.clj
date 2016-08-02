(ns hackerrank.compare-the-triplets
	(:require [clojure.java.io :as io])
;;             [hackerrank.save-the-prisoner :refer :all])
  (:use [clojure.string :only (split join)]))

; https://www.hackerrank.com/challenges/compare-the-triplets

(defn parseInt [n]
	(Integer/parseInt n))

(defn compare-triplets [first-line second-line]
  (let [a0_temp first-line
        a0_t (split a0_temp #"\s+")
        a0 (parseInt (a0_t 0))
        a1 (parseInt (a0_t 1))
        a2 (parseInt (a0_t 2))

        b0_temp second-line
        b0_t (split b0_temp #"\s+")
        b0 (parseInt (b0_t 0))
        b1 (parseInt (b0_t 1))
        b2 (parseInt (b0_t 2))

        max-points 100
;;         http://stackoverflow.com/questions/940712/redefining-a-letd-variable-in-clojure-loop
;;         locals never change, but you could use atom
        alice (atom 0)
        bob (atom 0)]

    (defn score [a b]
      ;; https://clojuredocs.org/clojure.core/cond
      (defn inc-points [person]
        (swap! person inc))

      ;; https://clojuredocs.org/clojure.core/swap!
      (cond (and (> (compare a b) 0) (< @alice max-points)) (inc-points alice)
            (and (< (compare a b) 0) (< @bob max-points)) (inc-points bob)))

    ;; https://clojuredocs.org/clojure.string/join
;;     (println "first-line" (join " " [a0 a1 a2]))
;;     (println "second-line" (join " " [b0 b1 b2]))

    (score a0 b0)
    (score a1 b1)
    (score a2 b2)

;;     (println "result" (join " " [@alice @bob]))

    (join " " [@alice @bob])))

;; (println (compare-triplets "5 6 7" "3 6 10"))

;; 2016-07-29 17:04
;; 1/7 points
;; o think of others test cases
;; o make it more testable
