;; read input number list
(defn coll-append [coll item]
  (concat coll (list item)))

(defn readed-lines [n]
  (loop [i 0
    	coll (list)]
    (if (< i n)
    	(recur (inc i)
    			(coll-append coll (read-line)))
    	coll)))
      
(defn parseInt [n]
	(Integer/parseInt n))

(defn readed-numbers [t]
	(map parseInt (readed-lines t)))

; for _ in xrange(input()):
;      print ["First","Second"][input()%7 in [0,1]]

(defn mod-7-equal [stones equal]
	(= (mod stones 7) equal))

(defn game-of-stones [stones]
	(if (or (mod-7-equal stones 0) (mod-7-equal stones 1)) 
		"Second"
		"First"))

(let [t (parseInt (read-line))
 	numbers (readed-numbers t)]
 	(doseq [stones numbers]
 		(println (game-of-stones stones))))
