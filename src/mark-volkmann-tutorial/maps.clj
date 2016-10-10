;; Maps
;; http://java.ociweb.com/mark/clojure/article.html#Collections
(def popsicle-map
  (hash-map :red :cherry, :green :apple, :purple :grape))

(def popsicle-map
  {:red :cherry, :green :apple, :purple :grape})

(def popsicle-map
  (sorted-map :red :cherry, :green :apple, :purple :grape))

;; get value of key :green
(get popsicle-map :green)
(popsicle-map :green)
(:green popsicle-map)

; contains? - check if is key
(contains? popsicle-map :green)
(keys popsicle-map)
(vals popsicle-map)

; add or replace value of key
(assoc popsicle-map :green :lime :blue :blueberry)

; remove keys
(dissoc popsicle-map :green :blue)
; (dissoc! popsicle-map :green)   ; clojure.lang.PersistentTreeMap cannot be cast to clojure.lang.ITransientMap

; doseq & destructing
(doseq [[color flavour] popsicle-map]
  (println (str "The flavour of " (name color) " popsicles is " (name flavour) ".")))

; return map with specified keys
(select-keys popsicle-map [:red :green :blue])

; add or replace value of key one map to second
(conj popsicle-map {:red :shit, :bad :boy})


(def person {
  :name "Mark Voljmann"
  :address {
    :street "asdf"
    :city "city"
    :state "M"
    :zip 12345}
  :employer {
    :name "name"
    :address {
      :street "asdf"
      :city "city"
      :state "M"
      :zip 12345}}})

; get person.employer.address.city
(get-in person [:employer :address :city])
(-> person :employer :address :city)   ; równoważne - -> == pipe
(reduce get person [:employer :address :city])
; in clojure.core.incubator
;; (-?> person :employer :city :address)
(-> person :employer :city :address) ; => return nil

; update person.employer.address.city
(assoc-in person [:employer :address :city] "Clayton")
(update-in person [:employer :address :zip] str "-1234")