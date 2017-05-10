;; Filter Positions in a List
;; https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list

(def input [2 5 3 4 6 7 9 8])

(->> input
     (map-indexed vector)
     (filter #(odd? (first %)))
     (map second))

;; HackerRank copy-paste
(fn [input]
  (->> input
     (map-indexed vector)
     (filter #(odd? (first %)))
     (map second)))
