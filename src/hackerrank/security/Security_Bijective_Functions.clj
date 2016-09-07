(ns hackerrank.security.security-bijective-functions
  (:import java.util.Scanner)
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))



(with-in-str "1"
;;   (def scan (Scanner. System/in))
  (def scan (Scanner. *in*))

  (println (. scan nextInt)))

;; (with-in-str "1"
;;   (println (read-line)))
