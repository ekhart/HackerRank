;; Pairwise Disjoint Sets
;; http://www.4clojure.com/problem/153

;; Difficulty:	Easy
;; Topics:	set-theory


;; Given a set of sets, create a function which returns true if no two of those sets have any elements in common1 and false otherwise. Some of the test cases are a bit tricky, so pay a little more attention to them.

;; 1Such sets are usually called pairwise disjoint or mutually disjoint.


(clojure.set/intersection #{\U} #{\s})
(empty? (clojure.set/intersection #{\U} #{\s}))

(defn check-sets [a s]
;;   (println "a" a "s" s)
;;   (empty? (clojure.set/intersection a s)))
;;   (println (filter #(clojure.set/intersection a %) s))
;;   (println (count (filter #(clojure.set/intersection a %) s))))
  (let [f (remove #(do ; (println "a" a "%" % "inter?" (clojure.set/intersection a %))
                     (empty? (clojure.set/intersection a %))) s)]
;;     (println "f" f)
    (> (count f) 1)))

(defn __ [s]
;;   (reduce check-sets s)) ;; cant use reduce like that
  (every? false? (map #(check-sets % s) s)))

(map-indexed println #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})



(defn check-sets [a s]
    (> (count (remove #(empty? (clojure.set/intersection a %)) s)) 1))



(defn __ [s]
  (every? false? (map (fn [a] (> (count (remove #(empty? (clojure.set/intersection a %)) s)) 1)) s)))



(= (__ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
   true)

(= (__ #{#{:a :b :c :d :e}
         #{:a :b :c :d}
         #{:a :b :c}
         #{:a :b}
         #{:a}})
   false)

(= (__ #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}})
   true)

(= (__ #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}})
   true)

(= (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
         #{#{:x :y :z} #{:x :y} #{:z} #{}}
         #{'[:x :y :z] [:x :y] [:z] [] {}}})
   false)

(= (__ #{#{(= "true") false}
         #{:yes :no}
         #{(class 1) 0}
         #{(symbol "true") 'false}
         #{(keyword "yes") ::no}
         #{(class '1) (int \0)}})
   false)

(= (__ #{#{distinct?}
         #{#(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}})
   true)

(= (__ #{#{(#(-> *)) + (quote mapcat) #_ nil}
         #{'+ '* mapcat (comment mapcat)}
         #{(do) set contains? nil?}
         #{, , , #_, , empty?}})
   false)


;; 4 clojure copy paste
(fn [s] (every? false? (map (fn [a] (> (count (remove #(empty? (clojure.set/intersection a %)) s)) 1)) s)))



;; _artem_uv's solution:
#(= (count (reduce (fn [x y] (into x y)) %)) (count (reduce (fn [x y] (into x (seq y))) '() %)))

;; _pcl's solution:
(fn [s] (let [l (reduce into '() s)] (= (count l) (count (set l)))))

;; aceeca1's solution:
#(apply distinct? (apply concat %))

;; adereth's solution:
(fn [sos]
  (reduce #(and %1 %2) true
  (for [s1 sos
        s2 sos]
    (cond (= s1 s2) true
          (and (some nil? s1) (some nil? s2)) false
          (every? nil? (map s1 s2)) true
          :else false))))

;; 0x89's solution:
(fn i [xxs]
   (let [x (first xxs)
         xs (rest xxs)]
     (if-not x
       true
       (if (some identity (for [e x
                                o xs]
                            (contains? o e)))
         false
         (i xs)))))
