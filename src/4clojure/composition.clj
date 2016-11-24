;; Function Composition
;; http://www.4clojure.com/problem/58

;; Difficulty:	Medium
;; Topics:	higher-order-functions core-functions


;; Write a function which allows you to create function compositions. The parameter list should take a variable number of functions, and create a function that applies them from right-to-left.


;; (defn __ [& fns]
;;   (reduce (fn [acc fun] (fn [& args] )) nil (reverse fns)))

;; got from clojure comp source code
(defn __
  ([f g] (fn [x] (f (g x))))
  ([f g h] (fn [& args] (f (g (apply h args))))))


;; *clojure-version*

((comp rest reverse) [1 2 3 4])
(rest (reverse [1 2 3 4]))

(doseq [f [reverse rest]]
  (println (f [1 2 3 4])))


(= [3 2 1] ((__ rest reverse) [1 2 3 4]))

(= 5 ((__ (partial + 3) second) [1 2 3 4]))

(= true ((__ zero? #(mod % 8) +) 3 5 7 9))

(= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))


;; 4Clojure copy paste


;; _artem_uv's solution:
(fn comp1
  ([] identity)
  ([f] f)
  ([f g]
     (fn
       ([] (f (g)))
       ([x] (f (g x)))
       ([x y] (f (g x y)))
       ([x y z] (f (g x y z)))
       ([x y z & args] (f (apply g x y z args)))))
  ([f g & fs]
     (reduce comp1 (list* f g fs))))
;; also copied from source code ;d

;; _pcl's solution:
(fn [& xs] (fn [& ys] (reduce #(%2 %1) (apply (last xs) ys) (rest (reverse xs)))))
;; I had something like this on mind

;; aceeca1's solution:
(fn [& x] (reduce (fn [f g] (fn [& a] (f (apply g a)))) x))

;; adereth's solution:
(fn [& fns]
  (fn [& args]
    (loop [rfns (rest (reverse fns))
           v (apply (last fns) args)]
      (if (seq rfns) (recur (rest rfns) ((first rfns) v))
        v))))
