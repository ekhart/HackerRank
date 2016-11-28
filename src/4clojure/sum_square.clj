;; Sum of square of digits
;; http://www.4clojure.com/problem/120
;; Difficulty:	Easy
;; Topics:	math


;; Write a function which takes a collection of integers as an argument. Return the count of how many elements are smaller than the sum of their squared component digits. For example: 10 is larger than 1 squared plus 0 squared; whereas 15 is smaller than 1 squared plus 5 squared.


(str 10)
(partition 1 (str "10"))
(clojure.string/split "10" #"")
(map #(Integer/parseInt %) (clojure.string/split "10" #""))
(reduce #(+ %1 (* %2 %2)) 0 (map #(Integer/parseInt %) (clojure.string/split "15" #"")))

;; (square 2)

(defn __ [coll]
  (count
    (filter
      #(< %
          (reduce (fn [a b] (+ a (* b b)))
                  0
                  (map (fn [c] (Integer/parseInt c))
                       (remove clojure.string/blank? (clojure.string/split (str %) #"")))))
      coll)))

(count (filter #(< % (reduce (fn [a b] (+ a (* b b))) 0 (map (fn [c] (Integer/parseInt c)) (clojure.string/split (str %) #"")))) (range 30)))


(= 8 (__ (range 10)))

(= 19 (__ (range 30)))

(= 50 (__ (range 100)))

(= 50 (__ (range 1000)))


;; 4clojure copy paste
(fn [coll]
  (count
    (filter
      #(< %
          (reduce (fn [a b] (+ a (* b b)))
                  0
                  (map (fn [c] (Integer/parseInt c))
                       (remove clojure.string/blank? (clojure.string/split (str %) #"")))))
      coll)))

;; _artem_uv's solution:
(fn [x] (count (filter #(< (first %) (last %)) (map #(vector % (loop [x (str %) r 0] (if (empty? x) r (recur (rest x) (+ r (* (- (int (first x)) 48) (- (int (first x)) 48))))))) x))))

;; _pcl's solution:
(fn [xs]
  (count
    (filter
      (fn [x] (< x (reduce + (map #(* % %) (map (comp read-string str) (str x))))))
      xs)))

;; aceeca1's solution:
(letfn [
    (good [x] (< x (apply + (map (comp #(* % %) #(- (int %) 48)) (str x)))))]
    (comp count (partial filter good)))

;; adereth's solution:
(fn [s]
  (let [squared-digits (fn [n]
                 (map second
                      (rest
                       (take-while #(not= % [0 0])
                                   (iterate
                                    (fn [[q r]] [(quot q 10) (* (rem q 10) (rem q 10))])
                                    [n 0])))))
        squared-digits-sum (->> s
                            (map squared-digits)
                            (map #(reduce + %)))
        is-smaller (map #(< %1 %2) s squared-digits-sum)
        ]
    (count (filter identity is-smaller))
   ))

;; 0x89's solution:
(fn [col]
  (let [b (fn [x] (->>
    x
    str
    (map #(Integer/parseInt (str %)))
    (map #(* % %))
    (reduce +)))]
     (count (filter
     #(< % (b %)) col))))