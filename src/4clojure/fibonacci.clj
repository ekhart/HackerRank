;; Fibonacci Sequence
;; http://www.4clojure.com/problem/26

(defn fib [n]
  (if (> n 1)
    (+ (fib (dec n)) (fib (- n 2)))
    1))

;; (fib 0)

(defn fib-seq [n]
  (loop [i 0
         coll []]
    (if (< i n)
      (recur (inc i) (conj coll (fib i)))
      coll)))


(= (fib-seq 3) '(1 1 2))
(= (fib-seq 6) '(1 1 2 3 5 8))
(= (fib-seq 8) '(1 1 2 3 5 8 13 21))

;; 4clojure copy-paste
(fn fib-seq [n]
  (letfn [(fib [n]
  	(if (> n 1)
    	(+ (fib (dec n)) (fib (- n 2)))
    	1))]
    (loop [i 0
           coll []]
      (if (< i n)
        (recur (inc i) (conj coll (fib i)))
        coll))))