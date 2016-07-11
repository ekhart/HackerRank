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
; (println (slurp test-file-path))

; http://stackoverflow.com/questions/36579613/how-to-read-n-lines-from-a-file-in-clojure
; process-file-by-lines: http://stackoverflow.com/questions/25948813/read-line-by-line-for-big-files
(defn lines [n filename]
	(with-open [rdr (io/reader filename)]
		(doall (take n (line-seq rdr)))))

(defn read-line []
	(lines 1 test-file-path))

(defn get-test-case-number []
	(parseInt (read-line)))


(defn test-read-line [file])

(defn save-the-prisoner [t]
	nil)