;; Pascal's Trapezoid
;; http://www.4clojure.com/problem/147

;; Difficulty:	Easy
;; Topics:	seqs


;; Write a function that, for any given input vector of numbers, returns an infinite lazy sequence of vectors, where each next one is constructed from the previous following the rules used in Pascal's Triangle. For example, for [3 1 2], the next row is [3 4 3 2].

;; Beware of arithmetic overflow! In clojure (since version 1.3 in 2011), if you use an arithmetic operator like + and the result is too large to fit into a 64-bit integer, an exception is thrown. You can use +' to indicate that you would rather overflow into Clojure's slower, arbitrary-precision bigint.

;; (defn nex [coll]
;;   (reduce #(conj %1 ) [] coll)

(defn nex [coll]
  (concat [(first coll)]
          (map-indexed #(+' %2 (if (>= (inc' %1) (count coll)) 0 (nth coll (inc' %1)))) coll)))

(nex [1 2 3])
(nex [1 3 3 1])

(defn red [a b]
  (conj a b))

;; (defn __
;;   ([] [])
;;   ([coll]
;;    (lazy-seq
;;      (conj [coll]
;;            (concat [(first coll)]
;;            (__ (map-indexed #(+ %2 (if (>= (inc %1) (count coll)) 0 (nth coll (inc %1)))) coll)))))))

;; (defn __ [coll]
;;    (lazy-seq
;;      (conj [coll]
;;            (__ (concat [(first coll)]
;;                        (map-indexed #(+ %2 (if (>= (inc' %1) (count coll)) 0 (nth coll (inc' %1))))
;;                                     coll))))))


(defn __ [coll]
   (lazy-seq (cons coll (__ (nex coll)))))


(defn positive-numbers
	([] (positive-numbers 1))
	([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(positive-numbers)

(= (second (__ [2 3 2])) [2 5 5 2])

(= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])

(= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])

(= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))


;; 4Clojure copy paste
(fn __ [coll] (lazy-seq (cons coll (__ (concat [(first coll)] (map-indexed #(+' %2 (if (>= (inc' %1) (count coll)) 0 (nth coll (inc' %1)))) coll))))))


;; _artem_uv's solution:
#(iterate (fn [x] (concat [(first x)]
                    (map +' x (rest x))
                    [(last x)]))
           %)

;; _pcl's solution:
(fn pt [xs]
  (lazy-seq
    (let
      [r (map + (cons 0 xs) (concat xs [0]))]
      (cons xs (pt r)))))

;; aceeca1's solution:
iterate (fn [x] (map (partial + 0N) (concat x [0]) (concat [0] x)))

;; adereth's solution:
(fn [row]
  (let [next-row #(map +' (concat [0] %) (concat % [0]))]
    (iterate next-row row)))

;; 0x89's solution:
#(iterate
          (fn [[x & xs :as all]]
            (flatten
              [x
               (map (partial apply +)
                    (partition 2 1 all))
               (last all)]))
          %
          )
