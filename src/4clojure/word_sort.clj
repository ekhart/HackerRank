;; Word Sorting
;; http://www.4clojure.com/problem/70

;; Difficulty:	Medium
;; Topics:	sorting


;; Write a function that splits a sentence up into a sorted list of words. Capitalization should not affect sort order and punctuation should be ignored.


(defn __ [string]
;;   (sort #(compare (.toLowerCase %1) (.toLowerCase %2)) (re-seq #"\w+" string)))
  (sort-by #(.toLowerCase %) (re-seq #"\w+" string)))

(re-seq #"\w+" "Have a nice day.")

(compare (.toLowerCase "Have") (.toLowerCase "a"))


(= (__  "Have a nice day.")
   ["a" "day" "Have" "nice"])

(= (__  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])

(= (__  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])


;; 4Clojure copy paste
(fn [s] (sort #(compare (.toLowerCase %1) (.toLowerCase %2)) (re-seq #"\w+" s)))


;; _artem_uv's solution:
#(sort (fn [a1 a2] (compare (clojure.string/upper-case a1) (clojure.string/upper-case a2))) (seq (clojure.string/split (clojure.string/replace % #"[\.\!]" "") #" ")))

;; _pcl's solution:
(fn [x] (sort-by #(.toLowerCase %) (.split (.replaceAll x "[^a-zA-Z ]" "") " ")))

;; aceeca1's solution:
(comp (partial sort-by clojure.string/lower-case) #(clojure.string/split % #"[^A-Za-z]"))

;; adereth's solution:
(fn [sent]
  (sort-by #(.toLowerCase %) (.split (->> sent butlast (apply str)) " ")))