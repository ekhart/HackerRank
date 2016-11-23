;; Find Distinct Items
;; http://www.4clojure.com/problem/56

;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.


;; (defn __ [coll]
;;   (sort (vec (set coll))))


;; (defn __ [coll]
;;   (reduce #(if-not (some (zipmap [%2] (repeat true)) %1) (conj %1 %2) nil) [] coll))


;; (defn __ [coll]
;;   (reduce #(do
;;              (println "%1 =" %1 "%2 =" %2)
;;              (if (some (fn [e] (= %2 e)) %1) %1 (conj %1 %2))) [] coll))

(defn __ [coll]
  (reduce #(if (some (fn [e] (= %2 e)) %1) %1 (conj %1 %2)) [] coll))


(if-not (boolean (some (fn [e] (= :a e)) [:a])) 'a)
;; == (if-not (some (fn [e] (= :b e)) [:b]) 'a)
(false? nil)
(boolean nil)

(conj [:a] :b)

;; use reduce to aggregate, some to find if element is in agregated coll
;; if not - conj, else: do nothing

(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])

(= (__ [:a :a :b :b :c :c]) [:a :b :c])

(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))

(= (__ (range 50)) (range 50))


;; 4clojure copy paste
(fn [coll] (reduce #(if (some (fn [e] (= %2 e)) %1) %1 (conj %1 %2)) [] coll))
;; my is one of the best

;; _artem_uv's solution:
(fn f
   ([s] (f s []))
   ([s r]
    (if (empty? s)
      r
      (if (contains? (apply hash-map (interleave  r (repeat (count r) 0))) (first s))
        (recur (rest s) r)
        (recur (rest s) (into r ((comp vector first) s)))))))

;; _pcl's solution:
#(sort-by (fn [i] (.indexOf % i)) (map first (group-by identity %)))

;; aceeca1's solution:
(comp keys (partial sort-by (comp first first last)) (partial group-by last) (partial map-indexed list))

;; adereth's solution:
#(loop [seen #{}
        remaining %
        result []]
   (if (empty? remaining) result
     (recur (conj seen (first remaining))
            (rest remaining)
            (if (seen (first remaining)) result
              (conj result (first remaining))))))
