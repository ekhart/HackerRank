;; Find Distinct Items
;; http://www.4clojure.com/problem/56

;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.


(defn __ [coll]
  coll)

;; use reduce to aggregate, some to find if element is in agregated coll
;; if not - conj, else: do nothing

(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])

(= (__ [:a :a :b :b :c :c]) [:a :b :c])

(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))

(= (__ (range 50)) (range 50))