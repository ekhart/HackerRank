; Enter your code here. Read input from STDIN. Print output to STDOUT
(defn exp [x n]
    (reduce * (repeat n x)))

(defn factorial [n]
	(reduce * (range 1 (inc n))))

(defn ex [x]
  (float (reduce #(+ %1 (/ (exp x %2) (factorial %2))) 0 (range 10))))

;; (println (exp 2 3))
;; (println (factorial 4))
;; (println (ex 0))
;; (println (ex 20))

(exp 2 3)
(factorial 4)

(ex 0)
(ex 20)
(ex 5)
(ex 0.5)
(ex -0.5)
