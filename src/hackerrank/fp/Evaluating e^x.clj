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

;; hackerrank
;; (println (ex (Integer/parseInt (read-line))))

(def input-string "4\n20.0000\n5.0000\n0.5000\n-0.5000")

(with-in-str input-string
  (let [n (Integer/parseInt (read-line))]
    (dotimes [i n]
      (let [x (Float/parseFloat (read-line))]
        (println (ex x))))))


(Float/parseFloat "1")
