;; Web Applications
;; http://java.ociweb.com/mark/clojure/article.html#WebApps

;; libs:
;; Noir: MVC, Enlive, Framework One
;; Compojure
;; all based on Ring
;; get from git, JARs, build with ANT

;; Compojure Hello, World!
(ns com.ociweb.hello
  (:use compojure))

(def host "localhost") ; -> better host =
(def port 8080)
(def in-path "/hello")
(def out-path "/hello-out")

(defn html-doc
  "generates well-formed HTML for a given title and body content"
  [title & body]
  (html
    (doctype :html4)
    [:html
     [:head [:title title]]
     [:body body]]))

; Creates HTML for input form.
(def hello-in
  (html-doc "Hello In"
            (form-to [:post out-path]
                     "Name: "
                     (text-field {:size 10} :name "World")
                     [:br]
                     (reset-button "Reset")
                     (submit-button "Greet"))))

; Creates HTML for resutl message.
(defn hello-out [name]
  (html-doc "Hello Out"
            [:h1 "Hello, " name "!"]))

(defroutes hello-service
  ; The following three lines map HTTP methods
  ; and URL patterns to response HTML.
  (GET in-path hello-in)
  (POST out-path (hello-out (params :name)))
  (ANY "*" (page-not-found))) ; displays ./public/404.html by default

(println (str "browse http://" host ":" port in-path))
; browse http://localhost:8080/hello

(run-server {:port port} "/*" (servlet hello-service))