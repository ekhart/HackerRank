;; Infix Calculator
;; http://www.4clojure.com/problem/135

;; Difficulty:	Easy
;; Topics:	higher-order-functions math


;; Your friend Joe is always whining about Lisps using the prefix notation for math. Show him how you could easily write a function that does math using the infix notation. Is your favorite language that flexible, Joe? Write a function that accepts a variable length mathematical expression consisting of numbers and the operations +, -, *, and /. Assume a simple calculator that does not do precedence and instead just calculates left to right.


(defn __ [& args]
;;  ((nth args 1) (first args) (nth args 2)))
  (reduce #(if (fn? (second %2))
             ((second %2) %1 (nth args (inc (first %2))))
             %1)
          (first args)
          (map-indexed vector args)))
;;   (map-indexed vector args))

(fn? 1)

(boolean (some #{+} [- 1 3]))


(next [1])

(__ 2 + 5)



(defn __ [& args]
  (->> args
      (map-indexed vector)
      (reduce #(if (fn? (second %2))
             ((second %2) %1 (nth args (inc (first %2))))
             %1)
          (first args))))



(= 7  (__ 2 + 5))

(= 42 (__ 38 + 48 - 2 / 2))

(= 8  (__ 10 / 2 - 1 * 2))

(= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))


(defn __ [& args]
  (reduce #(if (fn? (second %2))
             ((second %2) %1 (nth args (inc (first %2))))
             %1)
          (first args)
          (map-indexed vector args)))

;; (->> [2 + 5] (map-indexed vector))


;; 4clojure copy paste
(fn [& args]
  (->> args
      (map-indexed vector)
      (reduce #(if (fn? (second %2))
             ((second %2) %1 (nth args (incfirst %2))))
             %1)
          (first args)))



;; _artem_uv's solution:
(fn
  [a1 & args]
  (if (empty? args)
    a1
  (recur ((first args) a1 (second args)) (drop 2 args))))

;; _pcl's solution:
(fn [& xs]
  (reduce #((first %2) %1 (last %2)) (first xs) (partition 2 (rest xs))))

;; aceeca1's solution:
(fn infix [init & rawops] (let [
    ops (partition 2 rawops)
    do-op (fn [v op] ((first op) v (second op)))]
    (reduce do-op init ops)))

;; adereth's solution:
(fn [firstlhs & t]
  (let [oprhs (partition 2 t)]
    (reduce (fn [lhs [op rhs]] (op lhs rhs)) firstlhs oprhs)))

;; 0x89's solution:
(fn infix
  ([x op y] (op x y))
  ([x op y & xs]
   (apply infix (cons (infix x op y)
                xs))))
