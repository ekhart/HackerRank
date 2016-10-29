(def ^:dynamic v 1)

(defn f1 []
	(println "f1: v:" v))

(defn f2 []
	(println "f2: before let v:" v)
	; creates local binding v that shadows global one
	(let [v 2]
		; local binding only within this let statement
		(println "f2: in let, v:" v)
		(f1))