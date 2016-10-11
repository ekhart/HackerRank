;; http://www.4clojure.com/problem/156

(defn map-default [default coll]
  (assoc {} (first coll) default)
  (loop [l {} r coll]
    (if (empty? r)
      l
      (recur
        (assoc l (first r) default)
        (rest r)))))

(= 2 (:foo {:bar 0, :baz 1} 2))

(= (map-default 0 [:a :b :c]) {:a 0 :b 0 :c 0})
(= (map-default "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
(= (map-default [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})
