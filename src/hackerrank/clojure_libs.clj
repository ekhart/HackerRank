;; https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html
;; Clojure Libs and Namespaces: require, use, import, and ns

;;; The baseline: require
;; witout require it should throw Exception
;; (clojure.string/split "name,address,city,state,zip,email,phone" #",")

;; now should work
(require 'clojure.string)
(clojure.string/split "name,address,city,state,zip,email,phone" #",")
