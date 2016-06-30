(ns bfs)
(require '[clojure.string :as str])

(defn coll-append [coll item]
  (concat coll [item]))

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

(defrecord Bfs-test-case
	[nodes-count
	edges-count
	nodes-edges
	start-node])

;; https://en.wikipedia.org/wiki/Breadth-first_search
(defrecord Node [id distance parent])

;; http://stackoverflow.com/questions/28487435/why-does-pr-str-double-positive-infinity-return-different-responses
(def Infinity Double/POSITIVE_INFINITY)

(defn get-node [id]
	(Node. id Infinity nil))

(defn get-bfs-test-case []
	(let [numbers (line-numbers)
		nodes-count (get-nodes-count numbers)
		edges-count (get-edges-count numbers)
		nodes-edges (multiline-numbers edges-count)
		start-node (read-int)]
		(Bfs-test-case. nodes-count edges-count nodes-edges start-node)))

(defn get-bfs-test-cases [test-cases-count]
	(accumulate-coll test-cases-count get-bfs-test-case))

; how to implement graph ?
(defn get-graph [test-case]
	test-case)

(defn perform-test-case [test-case]
	(let [graph (get-graph test-case)
		root (get-node (:start-node test-case))]
		(println graph)
		(println root)))

; http://stackoverflow.com/questions/7314413/is-there-standard-foreach-function-in-clojure
(defn perform-test-cases [test-cases]
	(doseq [test-case test-cases]
		(perform-test-case test-case)))

; http://stackoverflow.com/questions/3136453/immutable-queue-in-clojure
; queue
(def queue list)
(def enqueue conj)
(def dequeue peek)
; also peek (get head), empty?

; tests
; TODO: how to TDD in clojure?
; http://www.bing.com/videos/search?q=how+to+tdd+in+clojure&view=detail&mid=4EA69960CC6B651045284EA69960CC6B65104528&FORM=VIRE

; (let [q (queue)
; 	q2 (enqueue q 1)]
; 	(println q)
; 	(println (enqueue q 1))
; 	(println q)
; 	(println q2)
; 	(println (dequeue q))
; 	(println q2)
; 	(println (empty? q))
; 	(println (empty? q2)))

; I.
; https://en.wikipedia.org/wiki/Breadth-first_search
;  1 Breadth-First-Search(Graph, root):
;  2
;  3     for each node n in Graph:
;  4         n.distance = INFINITY
;  5         n.parent = NIL
;  6
;  7     create empty queue Q
;  8
;  9     root.distance = 0
; 10     Q.enqueue(root)
; 11
; 12     while Q is not empty:
; 13
; 14         current = Q.dequeue()
; 15
; 16         for each node n that is adjacent to current:
; 17             if n.distance == INFINITY:
; 18                 n.distance = current.distance + 1
; 19                 n.parent = current
; 20                 Q.enqueue(n)
; (def breadth-first-search [graph root]
; 	(doseq [node graph]))

; II.
; Solution:  (python)
; https://gist.github.com/EDFward/4e7fd44ed019b62bb0d6
(defrecord Edge [source destination])

(defn get-edge [node-edge a b]
	(Edge. (node-edge a) (node-edge b)))

(defn get-2-dir-edges [node-edge]
  (conj [(get-edge 0 1)] (get-edge 1 0)))

(defn get-test-case-edges [nodes-edges]
  (loop [i 0
    	coll (list)]
    (if (< i (count nodes-edges))
    	(recur (inc i)
    		(concat coll (get-2-dir-edges (nodes-edges i))))
    	coll)))

(let [edges (get-test-case-edges [[1 2] [3 4]])]
	(println edges))

(defn calculate-shortest-distances [nodes-count edge start-node]
	(let [dist (repeat (inc nodes-count) Infinity)]))

(let [test-cases-count (read-int)
	test-cases (get-bfs-test-cases test-cases-count)]
	(perform-test-cases test-cases))

; (println (get-node 1))