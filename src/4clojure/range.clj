;; Implement range
;; http://www.4clojure.com/problem/34

(defn my-range [start stop]
  (take (- stop start) (iterate inc start)))


;; (take 4 (iterate inc ))

(= (my-range 1 4) '(1 2 3))
(= (my-range -2 2) '(-2 -1 0 1))
(= (my-range 5 8) '(5 6 7))

;; 4clojure copy-paste
#(take (- %2 %1) (iterate inc %1))