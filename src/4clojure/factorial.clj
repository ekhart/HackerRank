;; Factorial Fun
;; http://www.4clojure.com/problem/42

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(= (factorial 1) 1)

(= (factorial 3) 6)

(= (factorial 5) 120)

(= (factorial 8) 40320)

;; input:
;; #(reduce * (range 1 (inc %)))