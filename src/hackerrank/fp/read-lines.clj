(require '(clojure.java.io))

(doseq [ln (line-seq (java.io.BufferedReader. *in*))]
   (println ln))

(with-open [reader (clojure.java.io/reader *in*)]
	(count (line-seq reader)))

(with-open [rdr (clojure.java.io/reader "/etc/passwd")]
	(count (line-seq rdr)))
