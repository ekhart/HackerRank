;; Sequence Reductions
;; http://www.4clojure.com/problem/60 
;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which behaves like reduce, but returns each intermediate value of the reduction. Your function must accept either two or three arguments, and the return sequence must be lazy.

(defn __ 
  ([a b] true)
  ([a b c] true))

(= (take 5 (__ + (range))) [0 1 3 6 10])

(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])

(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)

(reduce conj [1] [2 3 4])
(reduce #(conj %1 %2) [1] [2 3 4])
(reduce #([(conj %1 %2)]) [1] [2 3 4])

(conj [1] (first [2 3 4]))

(loop [l []
       coll [2 3 4]]
  (if (empty? coll)
    l
    (recur (conj l (first coll)) (rest coll))))

(defn redu [f coll]
  (loop [l []
         c coll
         r []]
  (if (empty? c)
    r
    (recur (f l (first c)) 
           (rest c)
           (conj r l)))))
;; (rest [2 3 4])

(redu #(conj %1 %2) [1 2 3 4])
