(ns tic-tac-toe.tic-tac-toe
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]
        [clojure.pprint :only (pprint)]))

;; done:
;; TDD
;; printing array
;; player input
;; change [0 0] -> {:row 0 :col 0} - more readable

;; design:
;; 2 players: X, O
;; 1 plane 2d array with 9 places (3 x 3)

;; 1 random how start: x or o
;; 2 show clear table
;; 3 get player input: where to put its char
;; 3.1 check if position is empty? -> if not print "error" and get next valid input from player
;; 3.2 place player char in selected position
;; 4 check if player win: check horizontal line, vertical, cross
;; 4.1 if win then print: player x|o win!
;; 4.2 if there ar not empty

;; feature: change it to desktop app (use Java forms)

;; player vs player

;; player vs AI:
;; 0 - put at random first empty
;; 1 - algorithm - think where is best to place char


;; in-progres:

;; improve?

;; http://stackoverflow.com/questions/3937729/putting-doc-strings-on-data-vars-is-it-considered-idiomatic
;; todo: make it random at startup
(def
  ^{:doc "current player char" }
  *current-player* \o)

(def *array* [[nil nil nil]
            [nil nil nil]
            [nil nil nil]])

;; (def arry (make-array Integer/TYPE 3 3))
;; (for [_ (range 3)] (for [_ (range 3)] nil))

;; (reduce #(conj %1 (for [_ (range %2)] nil)) [] (repeat 3 3))
;; (reduce #(conj %1 (repeat %2 nil)) [] (repeat 3 3))
;; (repeat 3 (repeat 3 nil)) ; simpest


(defn join-row [row]
  (join "|" (map #(if (nil? %) " " %) row)))

(defn print-array [array]
  (print (join "\n-----\n" (map join-row array)))
  (println))

(defn chars-seq [string]
  (split string #""))

(defn map-to-ints [coll]
  (letfn [(parseInt-at [place] (Integer/parseInt (place coll)))]
    {:row (parseInt-at first)
     :col (parseInt-at second)}))

(defn player-input []
  (print "Where to put your sign? ")
  (-> (read-line) chars-seq map-to-ints))

;; ((memfn Integer/parseInt) "1") ; dont work

(defn get-array [input]
  (let [row-index (:row input)
        col-index (:col input)
        row (nth *array* row-index)
        updated-row (assoc row col-index \o)]
    (assoc *array* row-index updated-row)))

(defn change-player []
  (if (= *current-player* \o) \x \o))


