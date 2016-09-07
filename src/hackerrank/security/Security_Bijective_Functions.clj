;; Security Bijective Functions
;; https://www.hackerrank.com/challenges/security-bijective-functions/forum

(ns hackerrank.security.security-bijective-functions
  (:import java.util.Scanner)
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))


(def input "3\n2 2 2 3 3")

;; (with-in-str input
;;   (let [scan (Scanner. *in*)
;;         n (. scan nextInt)]
;;     (println n)))

(defn parseInt [string]
  (Integer/parseInt string))

(with-in-str input
  (let [n (parseInt (read-line))
        numbers (map parseInt (split (read-line) #" "))
        numbers-set (set numbers)]

;;     (println n)
;;     (println numbers)
;;     (println numbers-set)
;;     (println (count numbers-set))

    (println
      (if (= n (count numbers-set)) "YES" "NO"))))

;; translation to clojure
;; o python solutiion
