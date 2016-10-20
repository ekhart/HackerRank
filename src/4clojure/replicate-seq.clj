;; Replicate a Sequence
;; http://www.4clojure.com/problem/33

(defn __ [coll n]
  (mapcat #(take n (iterate identity %)) coll))

;; (take 2 (iterate identity 1))

(= (__ [1 2 3] 2) '(1 1 2 2 3 3))
(= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= (__ [4 5 6] 1) '(4 5 6))
(= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= (__ [44 33] 2) [44 44 33 33])

;; 4Clojure solution:
(fn [coll n] (mapcat #(take n (iterate identity %)) coll))


;; _artem_uv's solution:
;; (fn f
;;   ([s t]
;;    (f s t '()))
;;   ([s t r]
;;    (if (empty? s)
;;      (reverse r)
;;      (recur (rest s) t (into r (repeat t (first s)))))))
;;
;; _pcl's solution:
;; (fn [xs n] (mapcat #(repeat n %) xs))

;; aceeca1's solution:
;; (fn [x t] (mapcat (partial repeat t) x))

;; adereth's solution:
;; (fn [s n]
;;   (if (= n 1) s
;;     (apply interleave (repeat n s))))