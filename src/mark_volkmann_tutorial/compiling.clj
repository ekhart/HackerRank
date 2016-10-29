;; Compiling
;; http://java.ociweb.com/mark/clojure/article.html#Compiling

;; using Clojure scripts by Java
;; steps to build

;; java -classpath path/classes:path/clojure.jar com.ociweb.talk args


;; Java Calling Clojure
;; AOT
; :static, :gen-class :methods
;; (ns namespace
;;   (:gen-class
;;     :methods [^{:static true} [function-name [param-types] return-type]]))


(ns mark_volkmann_tutorial.compiling   ; com.ociweb.clj.Demo
  (:gen-class
    :methods [^{:static true} [getMessage [String] String]]))

;; # Note the hyphen at the beginning of the function name!
(defn getMessage [name]
  (str "Hello, " name "!"))

;; 2016-10-29 19:28
;; dont work yet
