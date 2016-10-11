; StructMaps
; http://java.ociweb.com/mark/clojure/article.html#StructMaps

; deprecated: use records
; similar to maps but optimized, ~Java Beans
(def vehicle-struct (create-struct :make :model :year :color)) ; long way
(defstruct vehicle-struct :make :model :year :color) ; short way

; must be in order, last are nils
(def vehicle (struct vehicle-struct "Toyota" "Prius"))
vehicle

; Note the use of def instead of defn because accessor returns
; a function that is then bound to "make".
(def make (accessor vehicle-struct :make))
(make vehicle)
(vehicle :make) ; same but slower
(:make vehicle) ; same but slower