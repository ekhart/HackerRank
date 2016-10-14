(use '[clojure.pprint :only (pprint)])
(use '[clojure.string :only (join)])

;; 2 players: X, O

;; 1 random how start: x or o
;; 2 show clear table
;; 3 get player input: where to put its char
;; 4 check if player win


(def array [[nil nil nil]
            [nil nil nil]
            [nil nil nil]])

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
