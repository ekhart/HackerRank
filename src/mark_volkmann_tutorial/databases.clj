;; Databases
;; http://java.ociweb.com/mark/clojure/article.html#Databases

; jdbc library in Clojure Contrib
; support trasactions, commit, rollback
; create, drop table
; insert, update, delete rows
; run queries
; PosgreSQL, MySQL

(use 'clojure.java.jdbc)

(let [db-host "localhost"
      db-port 5432 ; 3306
      db-name "HR"]

  ; The classname below must be int the classpath.
  (def db {:classname "org.postgresql.Driver" ; com.mysql.jdbc.Driver
           :subprotocol "postgresql" ; mysql
           :subname (str "//" db-host ":" db-port "/" db-name)
           ; Any additional map entries are passed to the driver
           ; as driver-specific properties
           :user "mvolkmann"
           :password "cljfan"})

  (with-connection db ; close connection when finished
    (with-query-results rs ["select * from Employee"] ; closes result set when finished
      ; rs will be a non-lazy seuqence of maps,
      ; one for each record in the result set.
      ; The keys in each map are the column names retrieved and
      ; their values are the column values for that resutl set row.
      (doseq [row rs]
        (println row :lastname)))))

; clj-record - persistance API similar to Ruby on Rails ActiveRecord