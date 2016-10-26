;; A Half-Truth
;; http://www.4clojure.com/problem/83

;; Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true, but not all of the parameters are true. Otherwise your function should return false.

(defn __ [& coll]
;;   (and ; (some true? coll)
;;        (not-every? true? coll)))
  (and (not (empty? (filter true? coll)))
      ; (seq (filter true? coll)) ; this lint is not true! in this case
      (not-every? true? coll)))

;; try to refact
(defn x [f]
  (partial f true?))

;; (not (empty? (filter true? [false true])))

;; not-any?
;; not-every?
;; (some true? [false true])

(= false (__ false false))

(= true (__ true false))

(= false (__ true))

(= true (__ false true false))

(= false (__ true true true))

(= true (__ true true true false))



;; 4Clojure solution
(fn __ [& coll]
  (and (not (empty? (filter true? coll)))
      (not-every? true? coll)))


;; other solution
;; _artem_uv's solution:
(fn [& s]
  (if (some #(= true %) (seq s))
    (if (some #(= false %) (seq s))
      true
      false)
    false))

;; _pcl's solution:
(fn [& args] (if (every? identity args) false (not (nil? (some identity args)))))

;; aceeca1's solution:
not=
;; best ;d

;; adereth's solution:
(fn [& vs]
  (true? (and (some not vs)
         (some identity vs))))


;; Your Ranking
;; Username: ekhart
;; Rank: 4640 out of 47147
;; Problems Solved: 60