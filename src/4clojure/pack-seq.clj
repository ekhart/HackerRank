;; Pack a Sequence
;; http://www.4clojure.com/problem/31

(defn list-contains? [x coll]
  (boolean (some #{x} coll)))

(defn pack [result x]
  (if (empty? result)
    (conj result [x])
    (if (list-contains? x (last result))
      (assoc result (dec (count result)) (conj (last result) x)))))

;; (pack [1] 1)

;; (reduce pack [] [1 1 2 1 1 1 3 3])
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
  (partition-by identity coll))

(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))

(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))

(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))


(list-contains? 10 '(100 101 102))

(dec (count [0 1]))
(assoc [0 1] 0 1)

;; https://github.com/ptrv/4clojure-solutions/blob/master/solutions.clj
(fn [coll] (partition-by identity coll))
;; failed to do it by myself

;; 4clojure solution
#(partition-by identity %)

;; could be shorter
;; _pcl's solution:
partition-by identity
