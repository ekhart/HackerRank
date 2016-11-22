;; dot product
;; http://www.4clojure.com/problem/143

;; Difficulty:	Easy
;; Topics:	seqs math


;; Create a function that computes the dot product of two sequences. You may assume that the vectors will have the same length.

;; https://en.wikipedia.org/wiki/Dot_product
(defn __ [v y]
  (reduce + (map * v y)))


(= 0 (__ [0 1 0] [1 0 0]))

(= 3 (__ [1 1 1] [1 1 1]))

(= 32 (__ [1 2 3] [4 5 6]))

(= 256 (__ [2 5 6] [100 10 1]))


;; 4clojure copy .parseBoolean
#(reduce + (map * %1 %2))


;; _artem_uv's solution:
#(reduce + (map * %1 %2))

;; _pcl's solution:
#(reduce + (map * %1 %2))

;; aceeca1's solution:
(comp (partial apply +) (partial map *))

;; adereth's solution:
(fn [v1 v2] (reduce + (map * v1 v2)))