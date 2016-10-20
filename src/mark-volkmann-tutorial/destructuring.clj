;; Destructuring
;; http://java.ociweb.com/mark/clojure/article.html#Destructuring

; in parameter list of function, or in let/binding

(defn approach1 [numbers]
  (let [n1 (first numbers)
        n3 (nth numbers 2)]
    (+ n1 n3)))


; Note the underscore used to represent the
; second item in the collection which isn't used.
(defn approach2 [[n1 _ n3]]
  (+ n1 n3))

(approach1 [4 5 6 7])
(approach2 [4 5 6 7])


; ampersand to reamaining items collection
(defn name-summary [[name1 name2 &  others]]
  (println (str name1 ", " name2) "and" (count others) "others"))

(name-summary ["Moe" "Larry" "Curly" "Shemp"])


; :as access to all collection
(defn first-and-third-percentage [[n1 _ n3 :as coll]]
  (/ (+ n1 n3) (apply + coll)))

(first-and-third-percentage [4 5 6 7])


; destructuring on maps
; its common to use local binding names same as keys
(defn summer-sales-percentage
  ; The keywords below indicate the keys whose values
  ; should be extracted by destructuring.
  ; The non-keywords are the local bindings
  ; into which the values are placed.
;;   [{june :june
;;     july :july
;;     august :august
;;     :as all}]
  ;; it could simplified
  [{:keys [june july august]
    :as all}]
  (let [summer-sales (+ june july august)
        all-sales (apply + (vals all))]
    (/ summer-sales all-sales)))

(def sales { :january 100
             :ferbruary 200
             :march 0
             :april 300
             :may 200
             :june 100
             :july 400
             :august 500
             :september 200
             :october 300
             :november 400
             :december 600})

(summer-sales-percentage sales)
