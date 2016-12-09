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
  (map #(check-sets % s) s))

(map-indexed println #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})


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