;; Advanced Destructuring
;; http://www.4clojure.com/problem/51

(def __ [1 2 3 4 5])

(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))

;; 4Clojure copy paste
[1 2 3 4 5]