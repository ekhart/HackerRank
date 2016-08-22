(defn gcd [a b]
    (if (zero? (mod a b))
        b
        (gcd b (mod a b))))

;; (let [f (fn [a b] (gcd a b)) [m n] (map read-string (re-seq #"\d+" (read-line)))] (println (f m  n)))


(max 10 45)
(min 10 45)
(mod 45 10)
(zero? 1)
(println (gcd 10 45))

