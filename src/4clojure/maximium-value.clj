;; Maximum value
;; http://www.4clojure.com/problem/38

(defn max [& coll]
  (reduce #(if (> %1 %2) %1 %2) coll))

(= (max 1 8 3 4) 8)
(= (max 30 20) 30)
(= (max 45 67 11) 67)

;; (source max)

;; 4Clojure solution
;; (fn [& coll] (reduce #(if (> %1 %2) %1 %2) coll))

;; _artem_uv's solution:
;; (fn [& x] (reduce (fn [y z] (if (< y z) z y)) 0 (seq x)))

;; my is better