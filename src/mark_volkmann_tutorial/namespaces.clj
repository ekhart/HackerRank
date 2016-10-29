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


; create-ns - create namespace, but dont make it default
; def - define symbol (with optional value) in default namespace - is macro, doesnt eval all
; intern - define symbol in selected name space - is function so need quoting
(def foo 1)
(create-ns 'com.ociweb.test)
(intern 'com.ociweb.test 'foo 2)
(println (+ foo com.ociweb.test/foo))


; ns-interns - map of all symbols defined in given, loaded namespace
; keys - Symbol object, values - Var (function, macro, binding)
(ns-interns 'clojure.string)


;; all-ns - list of all loaded namespaces
; defualt: clojure.core, clojure.main, clojure.set, clojure.xml, clojure.zip and user
; in REPL also: clojure.repl, clojure.java.javadoc

; namespace - return namespace of given symbol/keyword
; other functions: ns-aliases, ns-imports, ns-map, ns-name, ns-publics, ns-refers, ns-unalias, ns-unmap, remove-ns

; Some Fine Print - relations between Symbol, Var & Namespace
;; http://java.ociweb.com/mark/clojure/images/ClassDiagram.png