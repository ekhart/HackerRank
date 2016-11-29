;; Pascal's Triangle
;; http://www.4clojure.com/problem/97

;; Difficulty:	Easy
;; Topics:
;; http://www.4clojure.com/problem/97

;; Pascal's triangle is a triangle of numbers computed using the following rules:

;; - The first row is 1.
;; - Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.

;; Write a function which returns the nth row of Pascal's Triangle.


(defn factorial [n]
  (reduce * 1 (range 1 (inc n))))

(factorial 4)

(defn pascal-item [n k]
  (/ (factorial n)
     (* (factorial k) (factorial (- n k)))))

(pascal-item 4 2)

(defn pascal-row [n]
  (map #(pascal-item n %) (range (inc n))))

(pascal-row 4)

;; (defn __ [coll]
;;   (map pascal-row coll))


;; (map pascal-row [0 1 2])

(defn __ [n]
  (map #(pascal-item (dec n) %) (range n)))

(= (__ 1) [1])

(= (map __ (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])

(= (__ 11)
   [1 10 45 120 210 252 210 120 45 10 1])


;; 4Clojure copy paste
(fn [n]
  (letfn [(fact [n] (reduce * 1 (range 1 (inc n))))
        (pascal-item [n k]
                     (/ (fact n)
                        (* (fact k)
                           (fact (- n k)))))]
  (map #(pascal-item (dec n) %) (range n))))


;; _artem_uv's solution:
#(nth (iterate (fn [x] (concat [1]
                    (map + x (rest x))
                    [1]))
           [1]) (dec %))

;; _pcl's solution:
(fn [i]
  (reduce
    #(conj %1 (* (last %1) (/ (- i %2) %2)))
    [1] (range 1 i)))

;; aceeca1's solution:
(fn pascal [x] (if (= 1 x) [1] (let [
    pp (conj (pascal (dec x)) 0)]
    (map + pp (reverse pp)))))

;; adereth's solution:
(fn [n]
  (nth
    (iterate #(map +' (concat [0] %) (concat % [0])) [1])
   (dec n)

   ))

;; 0x89's solution:
(fn it
  ([n] (it n [1]))
  ([n acc]
    (if (= n 1)
      acc
      (recur (dec n)
             (concat [1]
             (map (partial apply +)
                  (partition 2 1 acc))
             [1]))
  )))