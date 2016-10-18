;; Sequences
;; http://java.ociweb.com/mark/clojure/article.html#Sequences

;; Java|Clojure collections, strings, streams, directory, XML trees
;; lazy sequences: cache-seq concat cycle distinct drop drop-last drop-while filter for interleave interpose iterate lazy-cat lazy-seq line-seq map partition range re-seq remove repeat replicate take take-nth take-while tree-seq

(map #(println %) [1 2 3])
;; REPL always fully evaluate
;; but when this code is run in script - it doesnt do anything, because map return lazy sequence

;; force eval by: first second nth last
;; dorun doall force eval in single lazy sequence
;; doseq for in one or many lazy sequences
;; for returns lazy

;; doseq dorun when force side effects, both return nil
;; doall when eval result need to be retained - holds head of sequence

;; doseq prefered over dorun - easier to read, faster
(dorun (map #(println %) [1 2 3]))
(doseq [i [1 2 3]] (println i))


(doseq [i [1 2 3]] (println i))
(dorun (map #(println %) [1 2 3]))
(doall (map #(do (println %) %) [1 2 3]))

;; lazy = create infinte sequences
(defn f
  "square the argument and divide by 2"
  [x]
  (println "calculating f of" x)
  (/ (* x x) 2.0))

; Create an infinte sequence of results from the function f
; for the values 0 through infinty.
; Note that the head of this sequence is being held in the binding "f-seq".
; This will cause the values of all evaluated items to be cached.
(def f-seq (map f (iterate inc 0)))

; Force evaluation of the first item in the infinte sequence, (f 0).
(println "first is" (first f-seq))

; Force evaluation of the first three items in the infinte sequence.
; Since the (f 0) has already been evaluated,
; only (f 1) and (f 2) will be evaluated.
(doall (take 3 f-seq))

(println (nth f-seq 2)) ; uses cached result -> 2.0