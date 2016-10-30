;; Flipping out
;; http://www.4clojure.com/problem/46

;; Difficulty:	Medium
;; Topics:	higher-order-functions

;; Write a higher-order function which flips the order of the arguments of an input function.


(defn __ [f]
  (fn [a b] (f b a)))


(= 3 ((__ nth) 2 [1 2 3 4 5]))

(= true ((__ >) 7 8))

(= 4 ((__ quot) 2 8))

(= [1 2 3] ((__ take) [1 2 3 4 5] 3))


;; 4Clojure copy paste
(fn [f] (fn [a b] (f b a)))


;; _artem_uv's solution:
;; #(fn [x y] (% y x))

;; _pcl's solution:
;; (fn [f] (fn [l r] (f r l)))

;; aceeca1's solution:
;; #(comp (partial apply %) reverse list)

;; adereth's solution:
;; (fn [f]
;;   (fn [& ps] (apply f (reverse ps))))