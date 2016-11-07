;; Split by Type

;; Difficulty:	Medium
;; Topics:	seqs

;; Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).


(defn __ [coll]
  (vals (group-by type coll)))


(= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})


;; 4Clojure copy paste
#(vals (group-by type %))


;; _artem_uv's solution:
#(map last (group-by type %))

;; _pcl's solution:
#(vals (group-by type %))

;; aceeca1's solution:
(comp vals (partial group-by type))

;; adereth's solution:
#(vals (group-by type %))

