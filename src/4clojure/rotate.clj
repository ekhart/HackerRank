;; Rotate Sequence
;; http://www.4clojure.com/problem/44

;; Difficulty:	Medium
;; Topics:	seqs


;; Write a function which can rotate a sequence in either direction.


(defn __ [n coll]
  (let [x (mod n (count coll))]
    (concat (drop x coll) (take x coll))))

(mod -2 (count [1 2 3 4 5]))

(drop 3 [1 2 3 4 5])

(take 3 [1 2 3 4 5])

;; (rotate


(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))

(= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))

(= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))

(= (__ 1 '(:a :b :c)) '(:b :c :a))

(= (__ -4 '(:a :b :c)) '(:c :a :b))


#(let [x (mod %1 (count %2))]
    (concat (drop x %2) (take x %2)))


_artem_uv's solution:
#(let [x (rem (+ (count %2) (rem %1 (count %2))) (count %2))]
   (flatten [(drop x %2) (take x %2)]))

_pcl's solution:
(fn [n xs]
  (let [i (mod n (count xs))]
    (concat (drop i xs) (take i xs))))

aceeca1's solution:
(fn [m x]
  (let [x (vec x) n (count x)]
    (map x
         (map
          #(mod (+ m %) n)
          (range n)))))