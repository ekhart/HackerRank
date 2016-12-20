;; Prime Numbers
;; http://www.4clojure.com/problem/67

;; Difficulty:	Medium
;; Topics:	primes


;; Write a function which returns the first x number of prime numbers.



(defn __ [n]
  [n])


(let [l (range 2 (* 5 5))
      p (first l)]
  (reduce #(conj (remove (fn [x] zero? (mod x p)) l) p))



(= (__ 2) [2 3])

(= (__ 5) [2 3 5 7 11])

(= (last (__ 100)) 541)