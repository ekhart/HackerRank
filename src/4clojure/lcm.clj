;; Least Common Multiple
;; http://www.4clojure.com/problem/100

;; Difficulty:	Easy
;; Topics:	math


;; Write a function which calculates the least common multiple. Your function should accept a variable number of positive integers or ratios.

;; https://en.wikipedia.org/wiki/Least_common_multiple
;; works for two numbers integers

;; + http://stackoverflow.com/questions/4229870/c-algorithm-to-calculate-least-common-multiple-for-multiple-numbers/4229930

;; http://clojure.org/reference/special_forms
(defn __
  ([a b & coll] (reduce __ 1 (concat [a b] coll)))
  ([a b]
    (letfn [(gcd [x y] (if (zero? y) x (gcd y (mod x y))))
            (abs [a] (if (pos? a) a (- a)))]
      (/ (* (abs a) (abs b))
         (gcd a b)))))


(== (__ 2 3) 6)

(== (__ 5 3 7) 105)

(== (__ 1/3 2/5) 2)

(== (__ 3/4 1/6) 3/2)

(== (__ 7 5/7 2 3/5) 210)


;; 4clojure copy paste
(fn __
  ([a b & coll] (reduce __ 1 (concat [a b] coll)))
  ([a b]
    (letfn [(gcd [x y] (if (zero? y) x (gcd y (mod x y))))
            (abs [a] (if (pos? a) a (- a)))]
      (/ (* (abs a) (abs b))
         (gcd a b)))))



;; _artem_uv's solution:
(fn [& a] (reduce (fn [x y] (* x (/ y ((fn [a b] (if (zero? b) a (recur b (mod a b)))) x y)))) (seq a)))

;; _pcl's solution:
(fn [& xs]
  (/ (apply * xs)
    (reduce #(if (zero? %2) % (recur %2 (mod % %2))) xs)))

;; aceeca1's solution:
(fn lcm [x1 & xn] (first (drop-while
    (fn [s] (not-every? #(zero? (mod s %)) xn))
    (iterate (partial + x1) x1))))

;; adereth's solution:
(fn [x & xs]
  (let [multiples (map (partial * x) (rest (range)))]
    (first
     (filter #(every?
               (fn [y] (zero? (mod % y)))
               xs)
             multiples))))

;; 0x89's solution:
(fn lcm [& args]
  (let [lcm-int (fn [args acc]
                  (let [values (map second acc)
                        [min-index min-value] (apply min-key second acc)
                        orig-min-value (args min-index)]
                    (if (every? (partial = (first values))
                                values)
                      min-value
                        (recur args
                               (assoc acc
                                      min-index
                                      [min-index (+ min-value orig-min-value)]))
                      )))
        indexed (vec
                  (map #(vector %1 %2)
                       (range)
                       args))]
    (lcm-int (vec args) indexed)
    )
  )