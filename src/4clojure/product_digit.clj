;; Product Digits
;; http://www.4clojure.com/problem/99
;; http://www.4clojure.com/problem/solutions/99

;; Difficulty:	Easy
;; Topics:	math seqs


;; Write a function which multiplies two numbers and returns the result as a sequence of its digits.


(defn __ [a b]
  (map #(Integer/parseInt %) (remove clojure.string/blank? (clojure.string/split (str (* a b)) #""))))

;; ((memfn Integer/parseInt n) "1")

(= (__ 1 1) [1])

(= (__ 99 9) [8 9 1])

(= (__ 999 99) [9 8 9 0 1])


;; 4Clojure copy paste
(fn [a b]
  (map #(Integer/parseInt %) (remove clojure.string/blank? (clojure.string/split (str (* a b)) #""))))


;; others
;; _artem_uv's solution:
#(reduce (fn [x y] (into x (vector (- (int y) 48)))) [] (str (* %1 %2)))

;; _pcl's solution:
(fn [x y] (map #(Integer/parseInt (.toString %)) (flatten (partition 1 (str (* x y))))))

;; aceeca1's solution:
(comp (partial map #(- (int %) 48)) str *)

;; adereth's solution:
(fn [x y] (let [digits (fn [n]
  (map second
       (rest
        (take-while #(not= % [0 0])
                    (iterate
                     (fn [[q r]] [(quot q 10) (rem q 10)])
                     [n 0])))))]
  (reverse (digits (* x y)))))