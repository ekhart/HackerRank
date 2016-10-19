;; Compress a Sequence
;; http://www.4clojure.com/problem/30

(defn my-distinct [coll]
  (reduce #(if (= %2 (last %1)) %1 (conj %1 %2)) [] coll))

(my-distinct [1 2 3 3 3 4])

(= (apply str (my-distinct "Leeeeeerrroyyy")) "Leroy")
(= (my-distinct [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (my-distinct [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

;; 4Clojure copy-paste
(fn [coll] (reduce #(if (= %2 (last %1)) %1 (conj %1 %2)) [] coll))
