;; Comparisons

;; Difficulty:	Easy
;; Topics:


;; For any orderable data type it's possible to derive all of the basic comparison operations (<, ≤, =, ≠, ≥, and >) from a single operation (any operator but = or ≠ will work). Write a function that takes three arguments, a less than operator for the data and two items to compare. The function should return a keyword describing the relationship between the two items. The keywords for the relationship between x and y are as follows:
;; x = y → :eq
;; x > y → :gt
;; x < y → :lt


(defn __ [f a b]
  (f a b))


#(cond (pos? (%1 %2 %3)) :gt
       (neg? (%1 %2 %3)) :lt
       (zero? (%1 %2 %3)) :eq)



(= :gt (__ < 5 1))

(= :eq (__ (fn [x y] (< (count x) (count y))) "pear" "plum"))

(= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3))

(= :gt (__ > 0 2))