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

;; game of stones
(def first-case 2)
(def second-case 3)
(def third-case 5)
(def first-player 1)
(def second-player 2)

;(defn can-player-remove? [stones]
	;(or (= stones first-case) (= stones second-case) (= stones third-case)))

(defn can-remove? [stones case]
	(>= stones case))

; http://clojuredocs.org/clojure.core/cond
(defn to-remove-count [stones]
	(cond (can-remove? stones third-case) third-case
		(can-remove? stones second-case) second-case
		(can-remove? stones first-case) first-case
		:else 0))

(defn can-player-remove? [stones]
	(pos? (to-remove-count stones)))

(defn remove-stones [stones to-remove]
	(- stones to-remove))

(defn if-first-player [player then else]
	(if (= player first-player) 
		then 
		else))

(defn change-player [player]
	(if-first-player player 
		second-player 
		first-player))

(defn winner [player]
	(if-first-player player 
		"Second"
		"First"))

(defn game-of-stones [stones]
	(loop [s stones
			player 1]
		(if (can-player-remove? s)
			(recur (remove-stones s (to-remove-count s))
				(change-player player))
			(winner player))))

; for _ in xrange(input()):
;      print ["First","Second"][input()%7 in [0,1]]
(defn game-of-stones [stones]
	(cond (= (mod stones 7) 0) "Second"
		(= (mod stones 7) 1) "Second"
		:else "First"))

; (println (can-player-remove? first-case))
; (println (to-remove-count 2))
; (println (can-player-remove? 1))
; (println (game-of-stones 10))

;(let [t (parseInt (read-line))]
;  (println (game-of-stones t)))

;; http://stackoverflow.com/questions/7314413/is-there-standard-foreach-function-in-clojure
;; doseq ~ foreach
(let [t (parseInt (read-line))
 	numbers (readed-numbers t)]
 	(doseq [stones numbers]
 		(println (game-of-stones stones))))


; If ,  can remove either  or  stones to win the game, so we print  on a new line. Recall that each player moves optimally, so  will not remove  stones because doing so would cause  to lose the game.
; moja wersja nie działa optymalnie bo zabiera zawsze w pierwszej kolejności 5, 3, 2
; nie przewiduje co się bardzie opłaca -> trzeba dodać tutaj nieco inteligencji ;d
; a bez tego nie da się zaliczyć