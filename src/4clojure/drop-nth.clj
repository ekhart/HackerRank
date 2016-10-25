;; Drop Every Nth Item
;; http://www.4clojure.com/problem/41

(def not-zero? (complement zero?))

(defn __ [coll n]
  (->> coll
       (map-indexed vector)
       (filter #(not-zero? (mod (inc (first %)) n)))
       (map second)))

;;   (map second (filter #(not-zero? (mod (inc (first %)) 3)) (map-indexed vector [1 2 3 4 5 6 7 8])))

(mod (inc 2) 3)

(def not-zero? (complement zero?))

(map second (filter #(not-zero? (mod (inc (first %)) 3)) (map-indexed vector [1 2 3 4 5 6 7 8])))

(filter [1 2 3 4 5 6 7 8])


(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])

(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])

(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

;; find solution
;; map-indexed

;; 4Clojure solution
(fn [coll n]
  (->> coll
       (map-indexed vector)
       (filter #((complement zero?) (mod (inc (first %)) n)))
       (map second)))


;; other
;; _artem_uv's solution:
(fn f
  ([s c] (f s c []))
  ([s c r]
   (if (empty? s)
     (flatten r)
     (recur (drop c s) c (conj r (take (- c 1) s))))))

;; _pcl's solution:
#(apply concat (partition-all (dec %2) %2 %1))

;; aceeca1's solution:
(fn [x s] (remove nil? (map #(if %2 %1 nil) x (cycle (concat (repeat (dec s) true) '(false))))))

;; adereth's solution:
;; partition-all
(fn [coll n]
  (->> (partition-all n coll)
       (map (partial take (dec n)))
       (flatten)))


;; Username: ekhart
;; Rank: 5047 out of 47109
;; Problems Solved: 57 / 156