;; https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html
;; Clojure Libs and Namespaces: require, use, import, and ns

(def to-split "name,address,city,state,zip,email,phone")
(def splitted (clojure.string/split to-split #","))

;;; The baseline: require
;; witout require it should throw Exception
(clojure.string/split to-split #",")

;; now should work
;; (require 'clojure.string)
;; (clojure.string/split to-split #",")

;; mutliple requires
;; every time new REPL - needed require
(require 'clojure.string 'clojure.test)
(clojure.string/join " " splitted)
(clojure.test/is (= 1 2))
