;; Input/Output
;; http://java.ociweb.com/mark/clojure/article.html#Sequences

(binding [*out* (java.io.FileWriter. "my.log")]
  ;; ...
  (println "This goes to the file my.log")
  ;; ...
  (flush)) 	; same as (flush *out*)

;; *in*, *out*, *err*

;; print - string to *out*
;; println - strint with newline to *out* - *flush-on-newline*
;; newline - prints newline to *out* -
;;

;; pr, prn - output is form that coul be readed by Clojure reader -> serializing Clojure data structs
;; *print-meta*

(let [obj1 "foo"
      obj2 {:letter \a :number (Math/PI) }] ; a map
  (println "Output from print:")
  (print obj1 obj2)

  (println "Output from println:")
  (println obj1 obj2)

  (println "Output from pr:")
  (pr obj1 obj2)

  (println "Output from prn:")
  (prn obj1 obj2))

;; remove space between print arguments
(println "foo" 19)
(println (str "foo" 19)) ; concat with str

;; print-str, println-str, pr-str, prn-str - prints to string not to *out*

;; printf - print formated string, format - return formated string

;; with-out-str, with-in-str - return string with printing (shadow *out*)

;; with-open - calls open at and: good for files, databases

;; line-seq - return lazy lines sequence from BufferedReader
(use '[clojure.java.io :only (reader)])

(defn print-if-contains [line word]
  (when (.contains line word)
    (println line)))

(let [file "my.log"
      word "fur"]
  ; with-open will close the reader after
  ; evaluating all the expressions in its body.
  (with-open [rdr (reader file)]
    (doseq [line (line-seq rdr)]
      (print-if-contains line word))))

;; slurp - read all file content
;; spit - write string to file & close it