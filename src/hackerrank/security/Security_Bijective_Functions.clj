(ns hackerrank.security.security-bijective-functions
  (:import java.util.Scanner)
  (:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join trim)]))


(def input "3\n1 2 3")

(with-in-str input
  (let [scan (Scanner. *in*)
        n (. scan nextInt)]
    (println n)))
