; Enter your code here. Read input from STDIN. Print output to STDOUT

; (let [t (Integer/parseInt (read-line))]
;  t)

; https://groups.google.com/forum/#!topic/light-table-discussion/SqVpquibZA4
; stdin doesnt implemented xd
(defn parseInt [n]
	(Integer/parseInt n))

(let [t (parseInt "1")]
  t)

(defn list-append [coll item]
  (concat coll (list item)))

(def a (list))
(println a)
(println (list-append (list-append a 1) 2))
(println a)

(defn lines [n]
  (loop [i 0
    	coll (list)]
    (if (< i n)
    	(recur (inc i)
    			(list-append coll (read-line)))
    	coll)))

(defn input-numbers [t]
	(map parseInt (lines t)))

(defn winner [i]
	(if (= i 1)
		"First"
		"Second"))

(def first-case 2)
(def second-case 3)
(def third-case 5)

(defn can-remove? [stones]
	(or (= stones first-case) (= stones second-case) (= stones third-case)))

(defn remove-stones [stones to-remove]
	(- stones to-remove))

(defn to-remove-count [stones]
	(if (> stones third-case)))	; tutaj raczej cond

(println (can-remove? 2))
(println (winner 0))

(defn game [stones]
	(winner 1))

; 2 players: 1, 2; n stones
; single move - remove 2, 3, 5 stones
; if unable - lose game

