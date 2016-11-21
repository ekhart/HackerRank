;; Symmetric Difference
;; http://www.4clojure.com/problem/88

;; Difficulty:	Easy
;; Topics:	set-theory


;; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.


(defn __ [a b]
  (set (remove #(and (a %) (b %)) (set (concat a b)))))



(= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(= (__ #{:a :b :c} #{}) #{:a :b :c})

(= (__ #{} #{4 5 6}) #{4 5 6})

(= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})


;; 4Clojure copy paste
(fn __ [a b] (set (remove #(and (a %) (b %)) (set (concat a b)))))


;; _artem_uv's solution:
#(into (clojure.set/difference %2 %1) (clojure.set/difference %1 %2))

;; _pcl's solution:
#(set (concat (apply disj %1 %2) (apply disj %2 %1)))

;; aceeca1's solution:
(fn xorset [x1 x2] (set (for [i (concat x1 x2) :when (not= (x1 i) (x2 i))] i)))

;; adereth's solution:
(fn [s1 s2]
    (set (concat (filter (complement s1) s2)
                   (filter (complement s2) s1))))