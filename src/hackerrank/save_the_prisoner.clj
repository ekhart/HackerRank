(ns hackerrank.save-the-prisoner)
(require '[clojure.java.io :as io])

;; https://www.hackerrank.com/challenges/save-the-prisoner

(defn parseInt [n]
	(Integer/parseInt n))

; http://stackoverflow.com/questions/7756909/in-clojure-1-3-how-to-read-and-write-a-file
(defn get-current-path []
	(System/getProperty "user.dir"))
; (println (get-current-path))

(def test-file-path "resources\\test-case.txt")
(def test-file-line-current-index (atom 0))
; (println (slurp test-file-path))

; http://stackoverflow.com/questions/36579613/how-to-read-n-lines-from-a-file-in-clojure
; process-file-by-lines: http://stackoverflow.com/questions/25948813/read-line-by-line-for-big-files
(defn lines [n filename]
	(with-open [rdr (io/reader filename)]
		(doall (take n (line-seq rdr)))))

(defn file-lines [filename]
	(with-open [rdr (io/reader filename)]
		(let [lines (line-seq rdr)]
			; (println "lines " lines)
			; (println "count " (count lines))
			(doall (take (count lines) lines)))))
; (println (file-lines test-file-path))

(defn file-line-at [filename at]
	(with-open [rdr (io/reader filename)]
		(nth (line-seq rdr) at)))
; (println (file-line-at test-file-path 0))
; (println (file-line-at test-file-path 1))

(defn read-line []
	(file-line-at test-file-path test-file-line-current-index))

(defn get-test-case-number []
	(parseInt (read-line)))

(defn test-read-line [file])

(defn save-the-prisoner [t]
	nil)

(println @test-file-line-current-index)		; get value of atom
(println test-file-line-current-index)		; get atom
; https://en.wikibooks.org/wiki/Clojure_Programming/By_Example
(swap! test-file-line-current-index inc)	; mutating permanent state variable
(println test-file-line-current-index)