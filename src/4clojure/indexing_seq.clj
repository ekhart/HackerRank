;; Indexing Sequences
;; http://www.4clojure.com/problem/157
;; Difficulty:	Easy
;; Topics:	seqs


;; Transform a sequence into a sequence of pairs containing the original elements along with their index.


(defn __ [coll]
  (map-indexed #(vector %2 %1) coll))


(= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]])

(= (__ [0 1 3]) '((0 0) (1 1) (3 2)))

(= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])


// 4clojure copy paste
(fn [l] (map-indexed #(vector %2 %1) l))

;; _artem_uv's solution:
#(map vector % (range))

;; _pcl's solution:
map-indexed #(vector %2 %1)

;; aceeca1's solution:
map-indexed #(list %2 %1)

;; adereth's solution:
#(map vector % (range))

;; 0x89's solution:
(fn [xs] (map-indexed (comp reverse vector) xs))