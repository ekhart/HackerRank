;; http://www.4clojure.com/problem/65 
;; Black Box Testing
;; Difficulty:	Medium
;; Topics:	seqs testing

;; Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.

;; Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.
;; You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.
;; test not run	

;; Special Restrictions
;; class
;; type
;; Class
;; vector?
;; sequential?
;; list?
;; seq?
;; map?
;; set?
;; instance?
;; getClass

(defn __ [a]
  (let [c (subs (str a) 0 1)]
    (cond (= c "#") :set
          (= c "{") :map
          (= c "[") :vector
          (= c "(") :list
          :else :list)))

(= :map (__ {:a 1, :b 2}))

(= :list (__ (range (rand-int 20))))

(= :vector (__ [1 2 3 4 5 6]))

(= :set (__ #{10 (rand-int 5)}))

(= [:map :set :vector :list] (map __ [{} #{} [] ()]))


;; passed!
(fn __ [a]
  (let [c (subs (str a) 0 1)]
    (cond (= c "#") :set
          (= c "{") :map
          (= c "[") :vector
          (= c "(") :list
          :else :list)))

;; Code Golf Score: 95

;; _artem_uv's solution:
;; #(let [r (str %)]
;;    (if (.contains r "#")
;;      :set
;;        (if (.contains r "{")
;;          :map
;;          (if (.contains r "[")
;;            :vector
;;            :list))))

;; _pcl's solution:
;; #(if
;;   (and (associative? %) (< 1 (count (flatten (list (last (seq (assoc % 0 1))))))) ) :map
;;   (let [c (conj % :a :b :c)]
;;     (cond 
;;       (= (take-last 3 c) [:a :b :c]) :vector
;;       (= (take      3 c) [:c :b :a]) :list
;;       true :set)))

;; aceeca1's solution:
;; (comp #(cond (= % {}) :map (= % #{}) :set (= (conj % 1 2) [1 2]) :vector true :list) empty)

;; adereth's solution:
;; #(condp = (nth (str %) 0)
;;    \{ :map
;;    \c :list
;;    \[ :vector
;;    \# :set)
