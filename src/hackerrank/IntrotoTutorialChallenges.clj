(require '[clojure.string :as str])

(def input-string "4\n6\n1 4 5 7 9 12")

(defn parseInt [string]
  (Integer/parseInt string))

(with-in-str input-string
  (let [v (parseInt (read-line))
        n (parseInt (read-line))
        ar (map parseInt (str/split (read-line) #" "))]
  (println (.indexOf ar v))))
