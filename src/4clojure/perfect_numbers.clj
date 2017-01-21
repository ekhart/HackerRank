;; Perfect Numbers
;; http://www.4clojure.com/problem/80

;; Difficulty:	Medium
;; Topics:


;; A number is "perfect" if the sum of its divisors equal the number itself. 6 is a perfect number because 1+2+3=6. Write a function which returns true for perfect numbers and false otherwise.

;; http://stackoverflow.com/questions/26753839/efficiently-getting-all-divisors-of-a-given-number
(defn __ [n]
  (= n
     (reduce +
             (filter #(zero? (mod n %))
                     (range 1 n)))))

(= (__ 6) true)

(= (__ 7) false)

(= (__ 496) true)

(= (__ 500) false)

(= (__ 8128) true)


;; 4Clojure copy paste
(fn [n] (= n (reduce + (filter #(zero? (mod n %))  (range 1 n)))))

;; _artem_uv's solution:
#(= (apply + (filter (comp zero? (partial rem %)) (range 1 %))) %)

;; _pcl's solution:
(fn [x]
  (let
    [divisors (filter #(zero? (mod x %)) (range 1 x))]
    (= x (reduce + divisors))))

;; aceeca1's solution:
(fn [x] (= x (apply + (filter #(= 0 (mod x %)) (range 1 x)))))

;; adereth's solution:
(fn [x]
  (let [factors (filter #(zero? (mod x %)) (range 1 x))]
    (= x (apply + factors))))
