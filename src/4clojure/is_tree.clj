;; To Tree, or not to Tree
;; http://www.4clojure.com/problem/95

;; Difficulty:	Easy
;; Topics:	trees


;; Write a predicate which checks whether or not a given sequence represents a binary tree. Each node in the tree must have a value, a left child, and a right child.


;; (tree-seq seq? identity '((1 2 (3)) (4)))

(defn boolean? [a]
  (not (or (= a true) (= a false))))

(boolean? false)

(defn node? [coll]
  (letfn [(node-or-nil? [a] (or (node? a) (nil? a)))]
    (and (not (or (= coll true) (= coll false)))
         (= (count coll) 3)
         (node-or-nil? (second coll))
         (node-or-nil? (nil? _3)))))

(node? '(:a (:b nil nil) nil))
(node? '(:a (:b nil nil)))
(node? '(:a nil ()))

(defn __ [coll]
  (node? coll))


(= (__ '(:a (:b nil nil) nil))
   true)

(= (__ '(:a (:b nil nil)))
   false)

(= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)

(= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)

(= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)

(= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
   false)

(= (__ '(:a nil ()))
   false)
