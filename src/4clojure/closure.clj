;; Simple closures

;; Difficulty:	Easy
;; Topics:	higher-order-functions math


;; Lexical scope and first-class functions are two of the most basic building blocks of a functional language like Clojure. When you combine the two together, you get something very powerful called lexical closures. With these, you can exercise a great deal of control over the lifetime of your local bindings, saving their values for use later, long after the code you're running now has finished.

;; It can be hard to follow in the abstract, so let's build a simple closure. Given a positive integer n, return a function (f x) which computes xn. Observe that the effect of this is to preserve the value of n for use outside the scope in which it is defined.


(defn __ [n]
  #(int (Math/pow % n)))

(int (Math/pow 2 2))

;; ((partial (memfn Math/pow) 2) 2)

;; (letfn [f [a] (Math/pow a)]

(((fn [a]
  (fn [b]
    (Math/pow b a))) 2) 16)

(= 256 ((__ 2) 16),
       ((__ 8) 2))

(= [1 8 27 64] (map (__ 3) [1 2 3 4]))

(= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4]))


;; copy paste
(fn [n] #(int (Math/pow % n)))


;; others
;; _artem_uv's solution:
(fn [x] #(apply * (repeat x %)))

;; _pcl's solution:
partial #(Math/pow %2 %1)

;; aceeca1's solution:
partial (fn [n x] (apply * (repeat n x)))

;; adereth's solution:
(fn [n] (fn [x] (reduce * (repeat n x))))