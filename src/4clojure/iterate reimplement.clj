;; Re-implement Iterate

;; Difficulty:	Easy
;; Topics:	seqs core-functions

;; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.


;; (defn __ [f x]
;;   (conj (for [i (range)] (f i))
;;         x))


;; not too simple, or elegant - rather hacky
(defn __ [f x]
  (loop [c [(bigint x)]
         g f
         i 0]
    (if (< i 101)
      (recur (conj c (g (bigint x)))
             (comp g f)
             (inc i))
      c)))


;; work in LightTable, but dont in 4Clojure
;; (defn __ [f x]
;;   (clojure.lang.Iterate/create f x))

;; #(clojure.lang.Iterate/create %1 %2)


(= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])

(= (take 100 (__ inc 0)) (take 100 (range)))

(= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))


;; 4clojure copy paste
(fn __ [f x]
  (loop [c [(bigint x)]
         g f
         i 0]
    (if (< i 101)
      (recur (conj c (g (bigint x)))
             (comp g f)
             (inc i))
      c)))

;; solutions
;; _artem_uv's solution:
(fn f [func fe] (lazy-seq (cons fe (f func (func fe)))))

;; _pcl's solution:
#(reductions (fn [i _] (%1 i)) (repeat %2))

;; aceeca1's solution:
(fn [f x] (reductions #(%2 %1) x (repeat f)))

;; adereth's solution:
(fn [f x]
  (map (fn [n]
         (loop [n n
                fx x]
           (if (zero? n) fx
             (recur (dec n) (f fx))))
         )
       (range)))

;; learned: reductions ~ reduce but collecting all results (steps)
;; (reduce ...) = (last (reductions ...))
