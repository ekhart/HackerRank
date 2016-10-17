;; Iteration
;; http://java.ociweb.com/mark/clojure/article.html#Iteration

; dotimes - execute n times expression, _ ommit value (from 0)
(dotimes [card-number 3]
  (println "deal card number" (inc card-number)))

(defn my-fn [ms]
  (println "entered my-fn")
  (Thread/sleep ms)
  (println "leaving my-fn"))

; while - execute body while is true
(let [thread (Thread. #(my-fn 1))]
  (.start thread)
  (println "started thread")
  (while (.isAlive thread)
    (print ".")
    (flush))
  (println "thread stopped"))


;; List Comprehension
; for - lazy, doseq - return nil, side-effects: :when, :while - filtering

(def cols "ABCD")
(def rows (range 1 4)) ; purposely larger than needed to demonstarte :while

(println "for demo")
; dorun - force evaluation of lazy for
(dorun
  (for [col cols :when (not= col \B)
        row rows :while (< row 3)]
    (println (str col row))))

(println "\ndoseq demo")
(doseq [col cols :when (not= col \B)
        row rows :while (< row 3)]
  (println (str col row)))

; my: doseq = (dorun (for ...))

; loop, recur