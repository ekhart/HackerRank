;; Vectors
;; http://java.ociweb.com/mark/clojure/article.html#Collections
; vector good for adding at back
(def stooges (vector "Moe" "Larry" "Curly"))
(def stooges ["Moe" "Larry" "Curly"])

(get stooges 1 "unknown")
(get stooges 3 "unknown")

; replace item at 2 & return new vector
(assoc stooges 2 "Shemp")

; MY
(subvec stooges 1)
(subvec stooges 1 2)

; list without last
(pop stooges)
; dont change stooges
stooges

; get last element
(peek stooges)
stooges

; "a" added to back
(conj stooges "a")