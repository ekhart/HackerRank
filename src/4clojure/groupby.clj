;; Group a Sequence
;; http://www.4clojure.com/problem/63

;; Difficulty:	Easy
;; Topics:	core-functions


;; Given a function f and a sequence s, write a function which returns a map. The keys should be the values of f applied to each item in s. The value at each key should be a vector of corresponding items in the order they appear in s.


(defn __ [f coll]
  (reduce #(assoc-in %1 [(f %2)]
                     (if-let [a (%1 (f %2))]
                       (conj a %2)
                       [%2]))
          {} coll))

;; (reduce conj [] [1 3 6 8])

(assoc-in {} [1] [2])
(assoc-in {1 [1]} [1] [2])
(assoc-in {1 [1]} [2] [2])


;; (if-let [a ({} )]
;;   (conj a %2)
;;   [%2])


(= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})

(= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})

(= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})


;; 4Clojure copy paste
(fn [f coll]
  (reduce #(assoc-in %1 [(f %2)]
                     (if-let [a (%1 (f %2))]
                       (conj a %2)
                       [%2])) {} coll))



;; _artem_uv's solution:
#(apply merge-with concat (map (fn [x] {(%1 x) [x]}) %2))

;; _pcl's solution:
(fn [f s]
  (apply merge-with concat (map #(hash-map (f %1) [%1]) s)))

;; aceeca1's solution:
(comp #(zipmap (map ffirst %) (map (partial map peek) %)) (partial partition-by first) sort (fn [f x] (map-indexed #(vector (f %2) %1 %2) x)))

;; adereth's solution:
(fn [f s]
  (reduce (fn [acc v]
            (merge-with
             concat
             acc
             {(f v) [v]}))
          {}
          s))
