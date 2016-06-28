(require '[clojure.string :as str])
;; (use '[clojure.string :as str])	;; replace clojure.core/reverse, replace with clojure.string

;; read input number list
(defn coll-append [coll item]
  (concat coll (list item)))

(defn accumulate-coll [number function]
  (loop [i 0
    	coll (list)]
    (if (< i number)
    	(recur (inc i)
    			(coll-append coll (function)))
    	coll)))

(defn readed-lines [n]
  (accumulate-coll n read-line))
      
(defn parseInt [n]
	(Integer/parseInt n))

(defn map-int [input]
	(map parseInt input))

(defn readed-numbers [t]
	(map-int (readed-lines t)))

;; http://clojuredocs.org/clojure.string/trim
(defn read-int []
	(parseInt (str/trim (read-line))))

;; https://clojuredocs.org/clojure.string/split
(defn line-numbers []
	(map-int (str/split (read-line) #" ")))

(defn multiline-numbers [lines-count]
	(accumulate-coll lines-count line-numbers))

(defn get-nodes-count [numbers]
	(nth numbers 0))

(defn get-edges-count [numbers]
	(nth numbers 1))

;; class test-case
; nodes-count
; edges-count
; nodes-edges
; start-node

;; http://clojuredocs.org/clojure.core/struct
; Structs are becoming obsolete. Use records instead. See defrecord
; (defstruct bfs-test-case 
; 	:nodes-count
; 	:edges-count
; 	:nodes-edges
; 	:start-node)

(defrecord Bfs-test-case 
	[nodes-count 
	edges-count 
	nodes-edges 
	start-node])

(defn get-bfs-test-case []
	(let [numbers (line-numbers)
		nodes-count (get-nodes-count numbers)
		edges-count (get-edges-count numbers)
		nodes-edges (multiline-numbers edges-count)
		start-node (read-int)]
		(Bfs-test-case. nodes-count edges-count nodes-edges start-node)))

(defn get-bfs-test-cases [test-cases-count]
	(accumulate-coll test-cases-count get-bfs-test-case))

; (let [test-cases-count (read-int)
; 	numbers (line-numbers)
; 	nodes-count (get-nodes-count numbers)
; 	edges-count (get-edges-count numbers)
; 	nodes-edges (multiline-numbers edges-count)
; 	start-node (read-int)]
; 	(println test-cases-count)
; 	(println numbers)
; 	(println nodes-count)
; 	(println edges-count)
; 	(println nodes-edges)
; 	(println start-node))

(let [test-cases-count (read-int)
	test-cases (get-bfs-test-cases test-cases-count)]
	(println test-cases))