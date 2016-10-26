;; Split a sequence
;; http://www.4clojure.com/problem/49

;; (defn __ [n coll]
;;   ;; https://clojuredocs.org/clojure.core/split-at
;;   [(take n coll) (drop n coll)])

;; (def __ (comp take drop))


(= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])

(= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])

(= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

;; 4Clojure copy paste
;; #([(take %1 %2) (drop %1 %2)]) ; raise error
(fn [n l] [(take n l) (drop n l)])

;; other solution
;; _artem_uv's solution:
#(into (into [] (vector (take %1 %2))) (vector (drop %1 %2)))

;; _pcl's solution:
(juxt take drop)
; -> the best: ((juxt a b c) x) => [(a x) (b x) (c x)]

;; aceeca1's solution:
(comp #(list (first %) (apply concat (next %))) partition-all)

;; adereth's solution:
(fn [n s] [(take n s) (drop n s)])