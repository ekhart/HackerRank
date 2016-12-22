;; Partition a Sequence
;; http://www.4clojure.com/problem/54

;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.



(defn __ [n coll]
  (loop [l []
         i 0]
    (let [sub (take n (drop i coll))]
      (if (and (< i (count coll)) (= n (count sub)))
        (recur (conj l sub) (+ i n))
      l))))



(__ 3 (range 9))

;; (subvec




(= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))

(= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))

(= (__ 3 (range 8)) '((0 1 2) (3 4 5)))



;; 4Clojure copy paste
#(loop [l [] i 0]
   (let [sub (take %1 (drop i %2))]
     (if (and (< i (count %2)) (= %1 (count sub)))
       (recur (conj l sub) (+ i %1))
       l)))



;; _artem_uv's solution:
(fn f
  ([c s] (f c s '()))
  ([c s r] (if (empty? s) (reverse r)
             (recur c (drop c s) (if (= (count (take c s)) c) (conj r (take c s)) r)))))

;; _pcl's solution:
(fn [s xs]
  (filter #(= (count %) s)
    (reduce
      (fn [w i]
        (if (= (count (last w)) s)
            (concat w [[i]])
            (concat (drop-last w) (list (conj (last w) i)))))
      [[]]
      xs)))

;; aceeca1's solution:
#(first (partition-by count (map (partial map first) (partition-by last (map list %2 (mapcat (partial repeat %1) (range)))))))

;; adereth's solution:
(fn ptn [n s]
  (let [next-chunk (take n s)]
    (if (= (count next-chunk) n)
      (cons next-chunk (ptn n (drop n s))))))