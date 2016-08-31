;; Even Tree
;; https://www.hackerrank.com/challenges/even-tree

(ns hackerrank.even-tree
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(defn parseInt [n]
  (Integer/parseInt n))


(defn numbers [string]
  (map parseInt (split string #" ")))

(defn make-tree []
  '())

(defn tree-add-edge [tree a b]
  (if (empty? tree)
    (cons b (cons (cons a nil) nil))))

(definterface INode
  (getLeft [])
  (getRight [])
  (insert [k v]))

(deftype Node
  [key
   val
   ^:volatile-mutable ^INode left
   ^:volatile-mutable ^INode right]

  INode
  (getLeft [_] left)
  (getRight [_] right)

  (insert [this k v]))


(defn even-tree
  ([]
   (let [first-line-numbers (numbers (read-line))
         n (nth first-line-numbers 0)
         m (nth first-line-numbers 1)]
     (println n)
     (println m)
     m))

  ([string-input]
   (with-in-str string-input
     (even-tree))))

;; uncomment after copy-paste to hackerrank buffer
;; (even-tree)

;; tree-seq
;; http://macromancy.com/2014/04/09/data-structures-clojure-trees.html
;; http://www.ibm.com/developerworks/library/j-treevisit/
;; https://www.cs.cmu.edu/~rwh/theses/okasaki.pdf - 6.2 Binary Representations
;; http://stackoverflow.com/questions/1787708/representing-a-tree-in-clojure

;; see
(cons 'a (cons 'b (cons 'c nil)))
(cons 'a (cons (cons 'b nil) nil))

(cons 'a nil)
(cons '() nil)
; (cons '() 'a)   ; error

(empty? '())
(empty? '(a))

(defn tree-add [tree a b]
  (if (empty? tree)
    (cons a nil)))

(tree-add '() 'a 'b)
