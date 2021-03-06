;; Reverse Interleave

;; Difficulty:	Medium
;; Topics:	seqs

;; Write a function which reverses the interleave process into x number of subsequences.


(defn __ [coll n]
  (vals (group-by #(mod % n) coll)))

;; (mod 5 3)

;; (nth [] 0)

;; (map-indexed (fn [i a] (mod i 2)) [1 2 3 4 5 6])

;; (reduce-kv

;; (repeat 2 [])

;; (conj (nth %1

;; (reduce #(conj (nth %1 (mod ) (repeat 2 []) [1 2 3 4 5 6])

(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

(= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

(= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))


;; 4Clojure copy paste
(fn [coll n]
  (vals (group-by #(mod % n) coll)))


;; _artem_uv's solution:
(fn [s c]
  (partition (/ (count s) c) (apply interleave (partition c s))))

;; _pcl's solution:
(fn [xs n] (apply map vector (partition n xs)))

;; aceeca1's solution:
#(apply (partial map list) (partition %2 %1))

;; adereth's solution:
#(apply (partial map vector) (partition %2 %1))
