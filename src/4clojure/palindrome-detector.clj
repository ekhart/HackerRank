;; Palindrome Detector
;; http://www.4clojure.com/problem/27

;; (defn palindrome? [coll]
;;   (println (int (/ (count coll) 2))))

(def not-nil? (complement nil?))

(defn palindrome? [coll]
  (loop [c coll
         r false]
    (let [f (first c)
          l (last c)]
      (if (and (not-nil? f) (not-nil? l) (= f l))
        (recur (-> c rest butlast) true)
        r))))


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

(first a)
(last a)
(= (first a) (last a))

(first nil)
(last nil)

(-> [1] rest butlast)


;; 4clojure solution
;; (fn palindrome? [coll]
;;   (loop [c coll
;;          r false]
;;     (let [f (first c)
;;           l (last c)
;;           not-nil? (complement nil?)]
;;       (if (and (not-nil? f) (not-nil? l) (= f l))
;;         (recur (-> c rest butlast) true)
;;         r))))

;; _artem_uv's solution:
;; #(if (= (apply str %) (apply str (vec (reverse %)))) true false)
