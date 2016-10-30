;; Libraries
;; http://java.ociweb.com/mark/clojure/article.html#Libraries

;; Clojure Contrib
;; http://dev.clojure.org/display/doc/Clojure+Contrib

;; clojure.tools.cli - command line arguments
;; clojure.data.xml
;; clojure.algo.monads
;; clojure.java.shell - run processes, stdin, stdout
;; clojure.stacktrace
;; clojure.tools.trace
;; clojure.string

(use 'clojure.java.shell)
(def directory (sh "pwd"))