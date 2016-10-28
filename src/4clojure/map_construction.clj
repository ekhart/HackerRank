;; Map Construction
;; http://www.4clojure.com/problem/61

;; Difficulty:	Easy
;; Topics:	core-functions

;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.


(defn __ [a b]\
  (into {} (mapv vector a b)))
;;         (map list a b) ; this (list) dont work - but vector is ok
;; ! it could be because of conj work diff on list and vector

(sorted-map)

(= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})

(= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})

(= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})

;; 4Clojure copy paste
#(into {} (mapv vector %1 %2))


;; other solutions - my solution is one of the best ;)
_artem_uv's solution:
#(apply hash-map (interleave %1 %2))

;; _pcl's solution:
(fn [keys vals]
  (last
    (reduce
      #(list
        (rest (first %1))
        (assoc (last %1) (ffirst %1) %2))
      [keys (hash-map)]
      (take (count keys) vals))))

;; aceeca1's solution:
(comp (partial apply sorted-map) interleave)

;; adereth's solution:
(fn [ks vs]
  (reduce merge (map (fn [k v] {k v}) ks vs)))