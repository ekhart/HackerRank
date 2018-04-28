;; Analyze a Tic-Tac-Toe Board
;; http://www.4clojure.com/problem/73 
;; Difficulty:	Hard
;; Topics:	game

;; A tic-tac-toe board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e. A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row. Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.

(defn __ [board] 
  nil)


(= nil (__ [[:e :e :e]
            [:e :e :e]
            [:e :e :e]]))

(= :x (__ [[:x :e :o]
           [:x :e :e]
           [:x :e :o]]))

(= :o (__ [[:e :x :e]
           [:o :o :o]
           [:x :e :x]]))

(= nil (__ [[:x :e :o]
            [:x :x :e]
            [:o :x :o]]))

(= :x (__ [[:x :e :e]
           [:o :x :e]
           [:o :e :x]]))

(= :o (__ [[:x :e :o]
           [:x :o :e]
           [:o :e :x]]))

(= nil (__ [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))

[[:e :e :e]
 [:e :e :e]
 [:e :e :e]]

(let [row [:x :x :x]
      f (first row)
      a (apply = row)]
  (if (and a (not= f :e)) f nil))

(reduce 
 #(let [f (first %)
       a (apply = %)]
   (if (and a (not= f :e)) f nil))
[[:e :e :e]
 [:e :e :e]
 [:e :e :e]])

;; find :x or :o in a row
(->> (map 
      #(let [f (first %)
             a (apply = %)]
         (if (and a (not= f :e)) f nil))
      [[:x :x :x]
       [:e :e :e]
       [:e :e :e]])
     (filter #(or (= % :x) (= % :o))))
