(defn map-with-indexes[coll]
	(map #(vector %1 %2) coll (range)))

(println (map-with-indexes ['a 'b]))

(defn odd? [pair]
	(= (mod (second pair) 2) 0))

(println (odd? [0 1]))
(println (odd? [0 2]))

(fn [lst]
	(filter odd? (map-with-indexes lst)))