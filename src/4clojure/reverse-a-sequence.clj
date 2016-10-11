;; Reverse a Sequence
;; http://www.4clojure.com/problem/23

(defn reverse-seq [coll]
  (loop [a '()
         b coll]
    (if (empty? b)
      a
      (recur
        (conj a (first b))   ; conj - add at first to list, at last to vector
        (rest b)))))

;; best solution
; reduce conj ()
; (def reverse-seq (partial (reduce conj ())))

(= (reverse-seq [1 2 3 4 5]) [5 4 3 2 1])
(= (reverse-seq (sorted-set 5 7 2 7)) '(7 5 2))
(= (reverse-seq [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])