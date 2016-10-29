;; Recursion
;; http://java.ociweb.com/mark/clojure/article.html#Recursion

; tail call optimalization: Java doesn't support & neither Clojure
; one way: loop, recur
; another way: trampoline - supports mutual recursion which dont support recur (fun call another fun which call back to the original one)

; loop, recur
(defn factorial-1 [number]
  "computes the factorial of a positive integer
  in a way that doesn't consume stack space"
  (loop [n number
         factorial 1]
    (if (zero? n)
      factorial
      (recur (dec n)
             (* factorial n)))))

(println (time (factorial-1 5)))

; another way of factorial - by reduce or apply (but it's even longer) - but its less effective
(defn factorial-2 [number]
  (reduce * (range 2 (inc number))))

(println (time (factorial-2 5)))
