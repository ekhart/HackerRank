;; Anagram Finder
;; http://www.4clojure.com/problem/77

;; Difficulty:	Medium
;; Topics:


;; Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y. Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other. Each sub-set should have at least two words. Words without any anagrams should not be included in the result.


(defn sort-chars [s]
  (apply str (sort s)))

(defn equal-sort-chars [a b]
  (= (sort-chars a)
     (sort-chars b)))


(defn __ [coll]
  (set (map #(apply str (sort %)) coll)))

(defn __ [coll]
  (set (filter #(> (count %) 1)
        (reduce #(conj %1 
                       (set (filter (fn [a] (equal-sort-chars a %2)) coll
)))
                #{}
                coll))))

;; ((comp set filter) #(> % 0) [-1 0 1])


;; 4Clojure copy paste
(fn [coll]
  (let [set-filter (comp set filter)
        sort-chars (fn [s] (apply str (sort s)))
        equal-sort-chars (fn [a b] (= (sort-chars a) (sort-chars b)))]
    (set-filter #(> (count %) 1)
        (reduce #(conj %1 
                       (set-filter (fn [a] (equal-sort-chars a %2)) coll
))
                #{}
                coll))))
;; code golf score: 222



(__ ["meat" "mat" "team" "mate" "eat"])
(__ ["veer" "lake" "item" "kale" "mite" "ever"])


(defn add [acc itm]
  (conj acc 
        (if (contains? acc (apply str (sort itm))) 
          
          #{itm})))

(def a (__ ["meat" "mat" "team" "mate" "eat"]))
a
(if (contains? a (apply str (sort "mat")))
  #{#{"meat"}})

;; (assoc #{} :a :b :c)

(require 'clojure.repl)
(clojure.repl/dir 'clojure.repl)

(rand-int 2)
(subs

(reduce add #{} ["meat" "mat" "team" "mate" "eat"])

(reduce #(conj %1 %2) #{} ["meat" "mat" "team" "mate" "eat"])

(def b ["meat" "mat" "team" "mate" "eat"])

(set (filter #(equal-sort-chars % "meat") b))

(remove #(> (count %) 1) #{#{"a" "b"} #{"c"}})

(set (filter #(> (count %) 1)
        (reduce #(conj %1 
                       (set (filter (fn [a] (equal-sort-chars a %2)) b)))
                #{}
                b)))

(= (__ ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})


;; others solutions
;; _artem_uv's solution:
(fn [arg] (set (map set (filter #(> (count %) 1) (map val (group-by #(set %) arg))))))
^
;; _pcl's solution:
(fn [words]
  (set
    (filter #(< 1 (count %))
      (map
        (fn [word]
          (set
            (filter #(= (group-by identity word) (group-by identity %)) words)))
        words))))

;; aceeca1's solution:
(fn [x] (set (for [i (vals (group-by sort x)) :when (< 1 (count i))] (set i))))

;; adereth's solution:
(fn [w]
  (->> w
       (group-by sort)
       vals
       (filter #(> (count %) 1))
       (map #(apply hash-set %))
       (apply hash-set)))
