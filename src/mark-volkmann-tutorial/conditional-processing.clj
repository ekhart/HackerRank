;; Conditional Processing
;; http://java.ociweb.com/mark/clojure/article.html#ConditionalProcessing

; if condition then-expr [else-expr] (optional)
; use do for more expressions
(import '(java.util Calendar GregorianCalendar))

(let [gc (GregorianCalendar.)
      day-of-week (.get gc Calendar/DAY_OF_WEEK)
      is-weekend (or
                   (= day-of-week Calendar/SATURDAY)
                   (= day-of-week Calendar/SUNDAY))]
  (if is-weekend
    (println "play")
    (do (println "work")
      (println "sleep")))

; when, when-not - alternative to if with one branch - dont needed do
  (when is-weekend (println "play"))
  (when-not is-weekend
    (println "work")
    (println "sleep")))

; if-let - bind single value & test if its true
(defn proccess-next [waiting-line]
  (if-let [name (first waiting-line)]
    (println name "is next")
    (println "no waiting")))

(proccess-next '("Jeremy" "Amanda"))
(proccess-next '())

; when-let - similar to if & when
(defn summarize
  "prints the first item in a colletction
  followed by a perdio for each remaining item"
  [coll]
  ; Execute the when-let body only if the collection isn't empty
  (when-let [head (first coll)]
    (print head)
    ; Below, dec subtracts one (decrements) from
    ; the number of items in the collection.
    (dotimes [_ (dec (count coll))]
      (print \.))
    (println)))

(summarize ["Moe" "Larry" "Curly"])
(summarize [])

; condp ~ switch/case statement: 2 param predicate (=, instance?)
