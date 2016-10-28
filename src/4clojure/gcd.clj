;; Greatest Common Divisor
;; http://www.4clojure.com/problem/66


;; Difficulty:	Easy
;; Topics:


;; Given two integers, write a function which returns the greatest common divisor.
;; test not run

;; https://en.wikipedia.org/wiki/Euclidean_algorithm
(defn __ [a b]
  (if (zero? b)
    a
    (__ b (mod a b))))


(= (__ 2 4) 2)

(= (__ 10 5) 5)

(= (__ 5 7) 1)

(= (__ 1023 858) 33)


;; 4Clojure copy paste
(fn __ [a b]
  (if (zero? b)
    a
    (__ b (mod a b))))


;; _artem_uv's solution:
;; (fn [x y] (if (zero? y) x (recur y (rem x y))))
;; -> could use recur with anonymous function

;; _pcl's solution:
;; (fn [x y] (apply max (filter #(= 0 (mod x %) (mod y %)) (range 1 (+ 1 (max (/ x 2) (/ y 2)))))))

;; aceeca1's solution:
;; (comp (partial apply +) first (partial drop-while (comp (partial < 0) (partial apply min))) #(iterate (fn [[x1 x2]] (vector (mod x1 x2) (mod x2 x1))) [%1 %2]))

;; adereth's solution:
;; (fn [v1 v2]
;;   (apply max
;;          (filter #(and (zero? (mod v1 %))
;;                        (zero? (mod v2 %)))
;;                  (range 1 (max v1 v2)))))