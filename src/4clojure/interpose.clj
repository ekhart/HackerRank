;; Interpose a Seq
;; http://www.4clojure.com/problem/40

(defn __ [x coll]
  (butlast (reduce #(conj %1 %2 x) [] coll)))

(= (__ 0 [1 2 3]) [1 0 2 0 3])

(= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")

(= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])


;; 4Clojure copy paste
(fn [x coll] (butlast (reduce #(conj %1 %2 x) [] coll)))

;; other solutions
;; _artem_uv's solution:
#(rest (interleave (repeat (count %2) %1) %2))

;; _pcl's solution:
(fn [sep xs]
  (drop-last (mapcat list xs (repeat sep))))

;; aceeca1's solution:
(fn [s x] (cons (first x) (mapcat #(list s %) (next x))))

;; adereth's solution:
#(butlast (interleave %2 (repeat %1)))