;; Palindrome Detector
;; http://www.4clojure.com/problem/27

;; (defn palindrome? [coll]
;;   (println (int (/ (count coll) 2))))

(defn palindrome? [coll]
  (loop [c coll
         r false]
    (if (not (= (first c) (last c)))
      false
      (recur
        (-> c rest butlast)
        true))))


(false? (palindrome? '(1 2 3 4 5)))
(true? (palindrome? "racecar"))
(true? (palindrome? [:foo :bar :foo]))
(true? (palindrome? '(1 1 3 3 1 1 )))
(false? (palindrome? '(:a :b :c)))

(def a (take 10 (iterate inc 1)))
a
(drop 1 (take (dec (count a)) a))
; <=>
(butlast (rest a))
; <=>
(-> a (rest) (butlast))
; <=> - more readable
(-> a rest butlast)
