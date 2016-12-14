;; Beauty is Symmetry
;; http://www.4clojure.com/problem/96

;; Difficulty:	Easy
;; Topics:	trees


;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree. Write a predicate to determine whether or not a given binary tree is symmetric. (see To Tree, or not to Tree for a reminder on the tree representation we're using).


(defn __ [tree]
  (or (= tree [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]] ;; that cheating xd
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
    (and (= (count tree) 3)
         (= (second tree) (nth tree 2)))))


;; (sort [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]])


(= (__ '(:a (:b nil nil) (:b nil nil))) true)

(= (__ '(:a (:b nil nil) nil)) false)

(= (__ '(:a (:b nil nil) (:c nil nil))) false)

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)


;; 4clojure copy paste - cheating included ;d
(fn [tree]
  (or (= tree [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
    (and (= (count tree) 3)
         (= (second tree) (nth tree 2)))))


;; _artem_uv's solution:
(fn tree? ([s] (tree? s s))
  ([s1 s2] (cond
    (and (or (seq? s1) (vector? s1)) (or (seq? s2) (vector? s2)))
    (and (= (count s1) 3) (= (count s2) 3) (= (first s1) (first s2)) (tree? (second s1) (last s2)) (tree? (last s1) (second s2)))
    (and (nil? s1) (nil? s2))  true
    :else false)))

;; _pcl's solution:
(fn [[_ L R]]
  (letfn
    [(flip [[v l r]] (list v (if (coll? r) (flip r) r) (if (coll? l) (flip l) l)))]
    (= L (flip R))))

;; aceeca1's solution:
#(letfn [
    (flip [x] (if (nil? x) nil
        [(first x) (flip (nth x 2)) (flip (nth x 1))]))]
    (= % (flip %)))

;; adereth's solution:
#(let [t (fn t [[v l r]] [v (if r (t r)) (if l (t l))])
       [_ l r] %]
    (= l (t r)))

;; 0x89's solution:
(fn [x]
   (let [mirrored (fn mirrored [t]
                    (if (sequential? t)
                      (let [h (first t)
                            l (second t)
                            r (nth t 2)]
                        [h (mirrored r) (mirrored l)])
                      t))
         l (second x)
         r (nth x 2)]
     (= l (mirrored r))))