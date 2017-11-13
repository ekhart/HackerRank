;; Sequence Reductions
;; http://www.4clojure.com/problem/60 
;; Difficulty:	Medium
;; Topics:	seqs core-functions

;; Write a function which behaves like reduce, but returns each intermediate value of the reduction. Your function must accept either two or three arguments, and the return sequence must be lazy.

;; Special Restrictions
;; reductions

(defn __ 
  ([a b] true)
  ([a b c] true))

;; (def __ reductions)
(def __ redu)

(= (take 5 (__ + (range))) [0 1 3 6 10])

(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
;; user> (__ conj [1] [2 3 4])
;; ([1] [1 2] [1 2 3] [1 2 3 4])

(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
;; user> (__ * 2 [3 4 5])
;; (2 6 24 120)
(reduce * 2 [3 4 5]) 
;; 120
(reductions * 2 [3 4 5])
;; (2 6 24 120)


(reduce conj [1] [2 3 4])
(reduce #(conj %1 %2) [1] [2 3 4])
(reduce #([(conj %1 %2)]) [1] [2 3 4])

(conj [1] (first [2 3 4]))

(loop [l []
       coll [2 3 4]]
  (if (empty? coll)
    l
    (recur (conj l (first coll)) (rest coll))))

(defn redu 
  ([f coll] (redu f 0 coll))
  ([f i coll]
   (loop [l i
          c coll
          r []]
     (if (empty? c)
       (conj r l)
       (do 
         (println (str "f " f " l " l " i " i " c " c))
         (recur (f l (first c)) 
                (rest c)
                (conj r l)))))))
;; (rest [2 3 4])

(redu #(conj %1 %2) [1 2 3 4])
(redu #(conj %1 %2) * [1 2 3 4])

(reduce * 2 [3 4 5])
; => 120
(reductions * 2 [3 4 5])
; => (2 6 24 120)
(redu * 2 [3 4 5])
; => [2 6 24]
;; working 2. & 3. test

(= (take 5 (__ + (range))) [0 1 3 6 10])
(take 5 (reductions + (range)))
(take 5 (redu + (range)))

(first (range))


;; https://github.com/clojure/clojure/blob/b98ba848d04867c5542d50e46429d9c1f2472719/src/clj/clojure/core.clj
;; reductions
;; (defn reductions
;;   "Returns a lazy seq of the intermediate values of the reduction (as
;;   per reduce) of coll by f, starting with init."
;;   {:added "1.2"}
;;   ([f coll]
;;      (lazy-seq
;;       (if-let [s (seq coll)]
;;         (reductions f (first s) (rest s))
;;         (list (f)))))
;;   ([f init coll]
;;      (if (reduced? init)
;;        (list @init)
;;        (cons init
;;              (lazy-seq
;;               (when-let [s (seq coll)]
;;                 (reductions f (f init (first s)) (rest s))))))))


;; copy paste solution
(fn __
  ([f coll] (__ f 0 coll))
  ([f i coll]
   (lazy-seq 
    (loop [l i c coll r []]
      (if (empty? c)
        (conj r l)
        (recur (f l (first c)) (rest c) (conj r l)))))))

;; (fn __
;;   ([f coll]
;;    (lazy-seq
;;     (if-let [s (seq coll)]
;;       (__ f (first s) (rest s))
;;       (list (f)))))
;;   ([f init coll]
;;    (if (clojure.lang.RT/isReduced init) 
;;      (list @init)
;;      (cons init
;;            (lazy-seq
;;             (when-let [s (seq coll)]
;;               (__ f (f init (first s)) (rest s))))))))
;; reduced? = clojure.lang.RT/isReduced
;; could not use it: You tripped the alarm! class clojure.lang.RT is bad!
