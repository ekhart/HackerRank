;; Duplicate a Sequence
;; http://www.4clojure.com/problem/32

(defn duplicate-seq [coll]
  (reduce #(conj %1 %2 %2) [] coll))


;; (conj [] 1 2)
(reduce #(conj %1 %2 %2) [] [1 2 3])

(= (duplicate-seq [1 2 3]) '(1 1 2 2 3 3))
(= (duplicate-seq [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (duplicate-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (duplicate-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

;; 4clojure solution
(fn duplicate-seq [coll]
  (reduce #(conj %1 %2 %2) [] coll))

;; better solution
;; #(sort (into % %))
