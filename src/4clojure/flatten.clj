;; Flatten a Sequence
;; http://www.4clojure.com/problem/28

(defn __ [coll]
  (remove sequential? (rest (tree-seq sequential? seq coll))))

(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
(= (__ '((((:a))))) '(:a))

(flatten ["a" ["b"] "c"])

;; hack: see source of special restrictions
;; works only with lein repl
;; not in LightTable nor in http://www.tryclj.com
;; (source flatten)
;; =>
;; (defn flatten
;;   "Takes any nested combination of sequential things (lists, vectors,
;;   etc.) and returns their contents as a single, flat sequence.
;;   (flatten nil) returns an empty sequence."
;;   {:added "1.2"
;;    :static true}
;;   [x]
;;   (filter (complement sequential?)
;;           (rest (tree-seq sequential? seq x))))

;; but it could be even shorter
(defn flatten [x]
  (remove sequential? (rest (tree-seq sequential? seq x))))

;; 4Clojure copy-paste
#(remove sequential? (rest (tree-seq sequential? seq %)))

;; reflect:
;; filter: return list when pred = true
;; remove: same but when pred = false
(filter (complement pred) ...) <=> (remove pred ...)