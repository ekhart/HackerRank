;; Prime Numbers
;; http://www.4clojure.com/problem/67

;; Difficulty:	Medium
;; Topics:	primes


;; Write a function which returns the first x number of prime numbers.



(defn __ [n]
  (take n (loop [l (range 2 (* n n))
         i 0]
    (if (< i (count l))
      (let [p (nth l i)
            lll (sort (conj (remove #(zero? (mod % p)) l) p))]
        (recur lll (inc i)))
      l))))


;; (let [l (range 2 (* 5 5))
;;       p (first l)]
;;   (reduce #(conj (remove (fn [x] zero? (mod x p)) l) p)))

(loop [l (range 2 (* 5 5))
       i 0]
  (if (< i (count l))
    (let [p (nth l i)
          lll (sort (conj (remove #(zero? (mod % p)) l) p))]
      (recur lll (inc i)))
      l))

(first [1])


(let [l (range 2 (* 5 5))
      p (second l)]
  (conj (remove #(zero? (mod % p)) l) p))


(= (__ 2) [2 3])

(= (__ 5) [2 3 5 7 11])

(= (last (__ 100)) 541)



;; 4Clojure copy paste
(fn [n] (take n (loop [l (range 2 (* n n)) i 0]
    (if (< i (count l))
      (let [p (nth l i)
            ll (sort (conj (remove #(zero? (mod % p)) l) p))]
        (recur ll (inc i)))
      l))))



;; _artem_uv's solution:
#(take % ((fn sieve [s]
  (cons (first s)
        (lazy-seq (sieve (filter (fn [xx] (not= 0 (mod xx (first s))))
                                 (rest s)))))) (iterate inc 2)))

;; _pcl's solution:
(fn primes [x]
  (if (= x 1)
    [2]
    (let [pp (primes (- x 1))]
      (conj pp
        (first (filter
          (fn [i] (every? #(< 0 (mod i %)) pp))
          (range (last pp) (* 2 (last pp)))))))))

;; aceeca1's solution:
(fn [x] (take x (filter #(= (inc (mod (apply * (range 1N %)) %)) %) (iterate inc 2))))

;; adereth's solution:
(fn [n]
  (->>
  (range)
  (drop 2)
  (filter (fn [x] (every? #(< 0 (mod x %)) (range 2 x))))
  (take n)))
