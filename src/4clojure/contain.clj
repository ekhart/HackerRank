;; Contain Yourself
;; http://www.4clojure.com/problem/47

;; The contains? function checks if a KEY is present in a given collection. This often leads beginner clojurians to use it incorrectly with numerically indexed collections like vectors and lists.

(def __ 4)


(contains? #{4 5 6} __)

(contains? [1 1 1 1 1] __)

(contains? {4 :a 2 :b} __)

(not (contains? [1 2 4] __))

;; Your Ranking
;; Username: ekhart
;; Rank: 5443 out of 46956
;; Problems Solved: 54