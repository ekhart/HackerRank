;; Interleave Two Seqs
;; http://www.4clojure.com/problem/39

;; (reduce #() [] [1 2 3]

(rest [1 2 3])

(defn __ [x y]
 (loop [result []
        a x
        b y]
    (if (or (empty? a) (empty? b))
      result
      (recur
        (conj result (first a) (first b))
        (rest a)
        (rest b)))))


(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))

(= (__ [1 2] [3 4 5 6]) '(1 3 2 4))

(= (__ [1 2 3 4] [5]) [1 5])

(= (__ [30 20] [25 15]) [30 25 20 15])


;; 4Clojure solution
#(loop [result []
        a %1
        b %2]
    (if (or (empty? a) (empty? b))
      result
      (recur
        (conj result (first a) (first b))
        (rest a)
        (rest b))))

;; others solutions
_artem_uv's solution:
#(flatten (map vector %1 %2))

_pcl's solution:
mapcat list

aceeca1's solution:
mapcat #(list %1 %2)

adereth's solution:
(fn [s1 s2]
  (flatten (map list s1 s2)))