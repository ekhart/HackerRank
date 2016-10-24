;; Pack a Sequence
;; http://www.4clojure.com/problem/31

(defn list-contains? [x coll]
  (boolean (some #{x} coll)))

(defn pack [result x]
  (if (empty? result)
    (conj result [x])
    (conj result [x])))

;; (reduce #(if (list-contains? 1 %
;; [[1] [1] [2] [1] [1] [1] [3] [3]]

(set [[1] [1] [2] [1] [1] [1] [3] [3]])
(set [1 1 2 1 1 1 3 3])
(count (filter #(= % 1) [1 1 2 1 1 1 3 3]))

;; (map #(repeat (count-if % coll) %) coll)

(concat [1] [1])

(defn __ [coll]
  (reduce pack [] coll))

;; !!
;; (defn count-if [x coll]
;;   (count (filter #(= % x) coll)))

;; (defn __ [coll]
;;   (map #(repeat (count-if % coll) %) (set coll)))
;; for first test -> ((1 1 1 1 1) (3 3) (2))
;; but should be '((1 1) (2) (1 1 1) (3 3))
;; so we must pack only neibours

(defn __ [coll]
  coll)

(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))

(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))

(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))


(list-contains? 10 '(100 101 102))