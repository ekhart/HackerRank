;; Juxtaposition
;; http://www.4clojure.com/problem/59

;; Difficulty:	Medium
;; Topics:	higher-order-functions core-functions


;; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.


(defn __
  ([f g h] ([(fn [& l] (apply f l))
             (fn [& l] (apply g l))
             (fn [& l] (apply h l))])))

(defn __ [& fns]
  ;; (map #(partial apply %) fns))
  (let [fns-map (map #(fn [l] (apply % l)) fns)]
    (fn [& args] (map #(% args) fns-map))))



[+ max min]
(map #(partial apply %) [+ max min])
(first (map #(partial apply %) [+ max min]))
;; ((first (map #(partial apply %) [+ max min])) 2)
;; ((first (map #(partial apply %) [+ max min])) 2 3 4 5 6)

(apply + [2])

;; (map #((fn [& l] (apply % l))))

((fn [& l] (apply + l)) 1 2 3)
;; ((first (map (fn [& l] (apply + l) [+ max min])) 2 3 4 5 6))

(def fns (map #(fn [& l] (apply % l)) [+ max min]))

(map #(% 1 2 3) fns)

(__ + max min)
((__ + max min) 1)



(defn __ [& fns]
  (let [fns-map (map #(fn [l] (apply % l)) fns)]
    (fn [& args] (map #(% args) fns-map))))



(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))

(= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))

(= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))


;; 4Clojure copy paste
(fn [& fns] (fn [& args] (map #(% args) (map #(fn [l] (apply % l)) fns))))


; _artem_uv's solution:
(fn [& f]
  (fn [& args]
    (map #(apply % args) (apply vector f))))

; _pcl's solution:
(fn [& fs] (fn [& xs]
  (if (> (count xs) 1)
      (map #(reduce % xs) fs)
      (map #(% (first xs)) fs))))

; aceeca1's solution:
(fn [& x] (fn [& a] (map #(apply % a) x)))

; adereth's solution:
(fn [& fns]
  (fn [& args]
    (for [f fns]
      (apply f args))))