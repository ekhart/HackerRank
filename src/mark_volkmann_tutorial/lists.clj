;; http://java.ociweb.com/mark/clojure/article.html#Collections
;; Lists

; ordered collection of items
; best for add/remove from first O(1), not good for search O(n)
(def stooges (list "Moe" "Larry" "Curly"))
(def stooges (quote ("Moe" "Larry" "Curly")))
(def stooges '("Moe" "Larry" "Curly"))

(some (partial = "Moe") stooges)
(some #(= % "Mark") stooges)
;; another approach is to create a set from the list
; and then use the contains? function on the set as follows
; -> set is more efficient for searching
(contains? (set stooges) "Moe")

; conj - create new list
; cons - create new sequence
; add item at front
(def more-stooges (conj stooges "Shemp"))
(def less-stooges (remove #(= % "Curly") more-stooges))

; into - concat 2 lists
(def kids-of-mike '("Greg" "Peter" "Bobby"))
(def kids-of-carol '("Marcia" "Jan" "Cindy"))
(def brandy-bunch (into kids-of-mike kids-of-carol))
(println brandy-bunch)

; peek & pop functions - as stack