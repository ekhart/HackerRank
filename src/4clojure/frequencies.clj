;; Count Occurrences
;; http://www.4clojure.com/problem/55

;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which returns a map containing the number of occurences of each distinct item in a sequence.


(defn __ [coll]
  (reduce #(assoc %1 %2 (count (filter (partial = %2) coll))) {} (set coll)))


(filter = (set [1 1 2 3 2 1 1]))


(= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})

(= (__ [:b :a :b :a :b]) {:a 2, :b 3})

(= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})


;; 4Clojure copy paste
(fn [coll] (reduce #(assoc %1 %2 (count (filter (partial = %2) coll))) {} (set coll)))


;; others
;; _artem_uv's solution:
#(let [x (group-by identity (sort %))] (apply hash-map (interleave (keys x) (map count (vals x)))))

;; _pcl's solution:
(fn [xs]
  (apply hash-map
    (apply concat
      (map #(list % (count (filter #{%} xs)))
           (set xs)
      )
    )
  )
)

;; aceeca1's solution:
(comp #(zipmap (keys %) (map count (vals %))) (partial group-by identity))

;; adereth's solution:
#(let [instances (group-by identity %)]
   (reduce (fn [acc v] (assoc acc v (-> (instances v) count)))
           {}
           (keys instances)))