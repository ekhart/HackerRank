;; Re-implement Map
;; http://www.4clojure.com/problem/118

;; Difficulty:	Easy
;; Topics:	core-seqs


;; Map is one of the core elements of a functional programming language. Given a function f and an input sequence s, return a lazy sequence of (f x) for each element x in s.



;; (defn __ [f coll]
;;   (loop [r []
;;          c coll]
;;     (if (empty? c)
;;       r
;;       (recur (conj r (f (first c)))
;;              (rest c)))))


;; (__ inc [])

;; (first [1 2 3])
;; (rest [1 2 3])

;; (conj [] (inc (first [1 2 3])))

(defn __ [f coll]
  (reduce #(conj %1 (f %2)) [] coll))



(= [3 4 5 6 7]
   (__ inc [2 3 4 5 6]))

(= (repeat 10 nil)
   (__ (fn [_] nil) (range 10)))

(= [1000000 1000001]
   (->> (__ inc (range))
        (drop (dec 1000000))
        (take 2)))

;; loook at map implementation
map

;; 4Clojure - fails only last test
#(loop [r [] c %2]
    (if (empty? c) r
      (recur (conj r (%1 (first c)))
             (rest c))))

;; 4Clojure - also fails
(fn [f coll] (reduce #(conj %1 (f %2)) [] coll))


;; solution form
;; https://github.com/qiuxiafei/4clojure/blob/master/answers/118.Re-implement Map
(fn mymap [f coll]
  (if (false? (empty? coll))
        (lazy-seq
          (cons (f (first coll)) (mymap f (rest coll))))))


;; artem_uv's solution:
(fn ff
    [f s] (if (not (empty? s)) (lazy-seq (cons (f (first s)) (ff f (rest s))))))

;; _pcl's solution:
(fn map2 [f xs]
  (lazy-seq
    (when-let [s (seq xs)]
      (cons (f (first s)) (map2 f (rest s))))))

;; aceeca1's solution:
(fn [f x] (rest (reductions #(f %2) nil x)))

;; adereth's solution:
#(reductions (fn [acc x] (%1 x)) (%1 (first %2)) (rest %2))

;; 0x89's solution:
(fn m [f col]
  (if (seq col)
     (lazy-seq
       (cons (f (first col))
             (m f (rest col))
               ))))

;; reflect: needed to use lazy-seq
