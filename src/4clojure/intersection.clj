;; Set Intersection
;; http://www.4clojure.com/problem/81


;; Difficulty:	Easy
;; Topics:	set-theory


;; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.

(defn coll-contains? [coll x]
  (some #{x} coll))

(some #{4} #{0 1 2 3})

(defn __ [a b]
  (set (filter #(coll-contains? b %) a)))


(= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})

(= (__ #{0 1 2} #{3 4 5}) #{})

(= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})

;; 4Clojure copy paste
(fn [a b] (set (filter #(some #{%} b) a)))


;; _artem_uv's solution:
(fn f
  ([s1 s2]
   (f s1 s2 '()))
  ([s1 s2 r]
   (if (empty? s1)
     (set r)
   (if (contains? s2 (first s1))
     (recur (rest s1) s2 (into r (vector (first s1))))
     (recur (rest s1) s2 r)))))

;; _pcl's solution:
(fn [x y] (reduce #(if (contains? x %2) (conj %1 %2) %1) #{}  y))

;; aceeca1's solution:
(comp set filter)
; shortest

;; adereth's solution:
(fn [s1 s2] (set (filter s1 s2)))
; equivalent of shortest but with not needed anonymous function