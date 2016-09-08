;; Security Involution
;; https://www.hackerrank.com/challenges/security-involution/forum

(ns hackerrank.security.security-involution
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))

(def input "2\n2 1")

(defn parseInt [string]
  (Integer/parseInt string))

(with-in-str input
  (let [n (parseInt (read-line))
        numbers (concat (map parseInt (split (read-line) #" ")))
        numbers2 (for [x numbers] (nth numbers (dec x)))]

    ;;     (println n)
;;     (println numbers)
;;     (println numbers2)
;;     (println (range 1 (inc n)))

    (println (if (= numbers2 (range 1 (inc n))) "YES" "NO")))

)
