;; http://java.ociweb.com/mark/clojure/article.html#Collections

(count [19 "yellow" true])

(def a [2 4 5])

(reverse a)

; the next line uses an anonymus function that adds 3 to its argument
(map #(+ % 3) a)
(map + a [5 6] [1 2 3 4])

; apply all args to fun
(apply + a)

; return single item form collection
(def stooges ["Moe" "Larry" "Curly" "Shemp"])
(first stooges)
(second stooges)
(last stooges)
(nth stooges 2)

; return multiple from collection
(next stooges)
(butlast stooges)
(drop-last 2 stooges)
; get names containing more than three Characters
(filter #(> (count %) 3) stooges)
(nthnext stooges 2)

; predicates
(every? #(instance? String %) stooges)
(not-every? #(instance? String %) stooges)
(some #(instance? Number %) stooges)
(not-any? #(instance? Number %) stooges)

;;;; MY
;; comp = function composition
;; (every? (comp instance? String) stooges) ;; dont work
;; ! bo String jest argumentem -> tutaj trzeba użyć nie kompozycji tylko curry -> partial

(every? (partial instance? String) stooges)
;; == (every? #(instance? String %) stooges)
;; równoważne tylko nie używamy % i funckji anonimowej