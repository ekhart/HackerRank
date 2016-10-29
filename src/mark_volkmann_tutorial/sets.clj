;; Sets
;; http://java.ociweb.com/mark/clojure/article.html#Collections
; no duplicates, un/sorted sets
(def stooges (hash-set "Moe" "Larry" "Curly"))   ; not sorted
(def stooges #{ "Moe" "Larry" "Curly" })
;; (def stooges (sorted-set "Moe" "Larry" "Curly"))

(contains? stooges "Moe")
(contains? stooges "Mark")

; set used as function
(stooges "Moe")
(stooges "Mark")
(if (stooges "Mark") "stooge" "regular person")

; for sorted set is added in order
;; (def stooges (sorted-set "Moe" "Larry" "Curly"))
(conj stooges "Ass")
(conj stooges "Zet")
;; for unsorted its not specified

(def more-stooges (conj stooges "Shemp"))
more-stooges
(def less-stooges (disj more-stooges "Curly"))
less-stooges

;; MY
(into #{} ["A" "B" "B"])   ; better (set ...)
