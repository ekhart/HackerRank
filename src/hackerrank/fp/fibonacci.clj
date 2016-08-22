;;              = 0 , n = 1
;; Fibonacci(n) = 1 , n = 2
;;                Fibonacci(n-1) + Fibonacci(n-2)  , n > 2

(defn fib [n]
  (if (<= n 2)
    (dec n)
    (+ (fib (dec n)) (fib (- n 2)))))

(fib 0)
(fib 1)
(fib 2)
(fib 3)
(fib 4)
(fib 5)
(fib 6)
(fib 7)

;; (println (fib (Integer/parseInt (read-line))))