(ns tic-tac-toe.tic-tac-toe
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))

(use '[clojure.pprint :only (pprint)])
(use '[clojure.string :only (join)])

;; done:
;; TDD
;; printing array

;; design:
;; 2 players: X, O
;; 1 plane 2d array with 9 places (3 x 3)

;; 1 random how start: x or o
;; 2 show clear table
;; 3 get player input: where to put its char
;; 3.1 check if position is empty? -> if not print "error" and get next valid input from player
;; 4 check if player win: check horizontal line, vertical, cross
;; 4.1 if win then print: player x|o win!
;; 4.2 if there ar not empty

;; feature: change it to desktop app (use Java forms)

;; player vs player

;; player vs AI:
;; 0 - put at random first empty
;; 1 - algorithm - think where is best to place char

;; todo:
;; get player input


(def array [[nil nil nil]
            [nil \x nil]
            [\o nil nil]])

;; (def arry (make-array Integer/TYPE 3 3))
;; (for [_ (range 3)] (for [_ (range 3)] nil))

(defn join-row [row]
  (join "|" (map #(if (nil? %) " " %) row)))

(join-row [nil 'o 'x])

(defn print-array [array]
  (print (join "\n-----\n" (map join-row array)))
  (println))

;; print array state
(print-array array)

;; 3 get player input
;; (with-in-str "0 0"
(defn player-input []
  nil)

