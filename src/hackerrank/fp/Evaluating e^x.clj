; Enter your code here. Read input from STDIN. Print output to STDOUT
(defn exp [x n]
    (reduce * (repeat n x)))

(defn factorial [n]
	(reduce * (range 1 (inc n))))

(println (exp 2 3))
(println (factorial 4))