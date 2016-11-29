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
  (map #(partial apply %) fns))


[+ max min]
(map #(partial apply %) [+ max min])
((first (map #(partial apply %) [+ max min])) 2 3 4 5 6)


(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))

(= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))

(= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))