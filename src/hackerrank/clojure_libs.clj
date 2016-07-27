;; https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html
;; Clojure Libs and Namespaces: require, use, import, and ns

(def to-split "name,address,city,state,zip,email,phone")
(def splitted (clojure.string/split to-split #","))

;;; The baseline: require
;; witout require it should throw Exception
;; (clojure.string/split to-split #",")

;; now should work
;; (require 'clojure.string)
;; (clojure.string/split to-split #",")

;; mutliple requires
;; every time new REPL - needed require
;; (require 'clojure.string 'clojure.test)
;; (clojure.string/join " " splitted)
;; (clojure.test/is (= 1 2))

; clojure.string map to folder %classpath%/clojure/string.clj

;; alias
;; (require '[clojure.string :as string])
;; the same as
;; (require ['clojure.string :as 'string])
;; (string/capitalize "foo")

;; multiple aliases
;; (require '[clojure.string :as str] '[clojure.test :as tst])
;; (string/capitalize "foo")
;; (tst/is (= 1 2))

;; same prefix
;; (require '(clojure string test))
;; (string/capitalize "foo")
;; (test/is (= 1 2))
;; must use vectors for libspecs
;; (require '(clojure [string :as string] test))
;; (string/join [1 2 3])

;; verbose
;; (require '[clojure.string :as string] :verbose)
;; (require '[clojure.test :as test] :verbose)

;; use
(use 'clojure.string)
(split "a,b,c" #",")
