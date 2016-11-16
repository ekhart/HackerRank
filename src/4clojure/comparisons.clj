;; Comparisons

;; Difficulty:	Easy
;; Topics:


;; For any orderable data type it's possible to derive all of the basic comparison operations (<, ≤, =, ≠, ≥, and >) from a single operation (any operator but = or ≠ will work). Write a function that takes three arguments, a less than operator for the data and two items to compare. The function should return a keyword describing the relationship between the two items. The keywords for the relationship between x and y are as follows:
;; x = y → :eq
;; x > y → :gt
;; x < y → :lt


;; (defn __ [f a b]
;;   (cond (pos? (f a b)) :gt
;;        (neg? (f a b)) :lt
;;        (zero? (f a b)) :eq))


(defn __ [f a b]
  (cond (f a b) :lt
       (f b a) :gt
       :else :eq))



#(cond (pos? (%1 %2 %3)) :gt
       (neg? (%1 %2 %3)) :lt
       (zero? (%1 %2 %3)) :eq)

(< 5 1)

(= < <)

;; (< "pear" "plum")


(= :gt (__ < 5 1))

(= :eq (__ (fn [x y] (< (count x) (count y))) "pear" "plum"))

(= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3))

(= :gt (__ > 0 2))

;; solution
;; https://github.com/qiuxiafei/4clojure/blob/master/answers/166.%20Comparisons


;; copy paste
(fn [f a b]
  (cond (f a b) :lt
       (f b a) :gt
       :else :eq))


;; others
;; _artem_uv's solution:
#(if (%1 %2 %3)
   :lt
   (if (%1 %3 %2)
     :gt
     :eq))

;; _pcl's solution:
(fn [lt x y] (if (lt x y) :lt (if (lt y x) :gt :eq)))

;; aceeca1's solution:
(fn [lt x1 x2]
    (cond
        (lt x1 x2) :lt (lt x2 x1) :gt true :eq ))

;; adereth's solution:
(fn [lto i1 i2]
  (cond
   (lto i1 i2) :lt
   (lto i2 i1) :gt
   :else :eq))
