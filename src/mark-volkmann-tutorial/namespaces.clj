;; Namespaces
;; http://java.ociweb.com/mark/clojure/article.html#Namespaces

; symbols are grouped in namespace: vars, refs, atoms, agents, functions, macors, other namespaces
; current, default namespace = *ns* - "user"
; in-ns - changes namespace
; ns does more: changes namespace (in-ns), auto-import clojure.core

*ns*

; access symbols in other namespace by clojure.string/join
(clojure.string/join " " ["a" "b"])

; require loads library
(require 'clojure.string)
(clojure.string/join "$" [1 2 3])

; alias - create aliast to namespace
(alias 'su 'clojure.string)
(su/join "$" [1 2 3])

; refer - makes all symbols accessible in current without namespace-qualify
; throws exception warnings if names collisions
(refer 'clojure.string)
(su/join "$" [1 2 3])

; use = refer + alias
(use 'clojure.string)

; ns macro supports :require, :use, :import (Java classes)
; use it on file beginning: :as - alias
; :only - load only part of library
(ns com.ociweb.demo
  (:require [clojure.string :as su])
  ; assumes this dependecy: [org.clojure/math.numeric-tower "0.0.1"]
;;   (:use [clojure.math.numeric-tower :only (gcd, sqrt)])   ; cant find dependecy
  (:import (java.text NumberFormat) (javax.swing JFrame JLabel)))

(println (su/join "$" [1 2 3]))
;; (println (gcd 27 72))
;; (println (sqrt 5))
(println (.format (NumberFormat/getInstance) Math/PI))

(doto (JFrame. "Hello")
  (.add (JLabel. "Hello, World!"))
  (.pack)
  (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
  (.setVisible true))