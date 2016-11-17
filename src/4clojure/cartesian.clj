;; Cartesian Product
;; http://www.4clojure.com/problem/90

;; Difficulty:	Easy
;; Topics:	set-theory


;; Write a function which calculates the Cartesian product of two sets.


;; http://stackoverflow.com/questions/18246549/cartesian-product-in-clojure

(defn __ [xs ys]
   (set
     (mapcat (fn [x]
               (map (fn [y] (list x y)) ys))
             xs)))


(= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= (__ #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (__ (into #{} (range 10))
                  (into #{} (range 30)))))


;; 4clojure copy paste
(fn [xs ys]
  (set (mapcat (fn [x] (map (fn [y] (list x y)) ys)) xs)))


;; _artem_uv's solution:
#(into #{} (for [x %1 y %2] [x y]))

;; _pcl's solution:
(fn [xs ys]
  (set
    (mapcat
      (fn [i] (map #(list i %) ys))
      xs)))

;; aceeca1's solution:
(fn [x1 x2] (set (for [i1 x1 i2 x2] [i1 i2])))

;; adereth's solution:
(fn [s1 s2]
  (set (for [v1 s1
             v2 s2] [v1 v2])))
