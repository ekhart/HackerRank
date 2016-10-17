; produce infinte lazy seq
(take 5 (iterate #(+ 3 %) 1))

(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))