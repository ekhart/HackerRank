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

;; Using other namespaces’ code as though it’s yours: use

;; use
;; (use 'clojure.string)
;; (split "a,b,c" #",")
;; replaces other already loaded functions

;; use only
;; (use '[clojure.string :only [split]])
;; (split "a,b,c" #",")
;; use only function we needed

;; use exclude
;; (use '[clojure.string :exclude [replace reverse]])
;; (split "a,b,c" #",")
;; eliminates shadowing of name colissions
;; best: use only with :only

;; use rename
;; (use '[clojure.string :rename {replace str-replace, reverse str-reverse}])
;; (str-reverse "foobar")
;; (reverse "foobar")

;; use :as
(use '[clojure.string :as str :only [join split]])
(str/replace "foobar" "f" "p")
;; same as require, so dont use it better
