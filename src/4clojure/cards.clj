;; Recognize Playing Cards
;; http://www.4clojure.com/problem/128

;; Difficulty:	Easy
;; Topics:	strings game


;; A standard American deck of playing cards has four suits - spades, hearts, diamonds, and clubs - and thirteen cards in each suit. Two is the lowest rank, followed by other integers up to ten; then the jack, queen, king, and ace.

;; It's convenient for humans to represent these cards as suit/rank pairs, such as H5 or DQ: the heart five and diamond queen respectively. But these forms are not convenient for programmers, so to write a card game you need some way to parse an input string into meaningful components. For purposes of determining rank, we will define the cards to be valued from 0 (the two) to 12 (the ace)

;; Write a function which converts (for example) the string "SJ" into a map of {:suit :spade, :rank 9}. A ten will always be represented with the single character "T", rather than the two characters "10".


(defn __ [st]
  (let [[s r] st
        suit-map {\D :diamond \H :heart \C :club \S :spade}
        rank-map {\A 12 \K 11 \Q 10 \J 9 \T 8 \9 7 \8 6 \7 5 \6 4 \5 3 \4 2 \3 1 \2 0}]
    {:suit (suit-map s)
     :rank (rank-map r)}))


({"D" :diamond "H" :heart "C" :club "S" :spade} "D")


(= {:suit :diamond :rank 10} (__ "DQ"))

(= {:suit :heart :rank 3} (__ "H5"))

(= {:suit :club :rank 12} (__ "CA"))

(= (range 13) (map (comp :rank __ str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA]))


;; 4Clojure copy paste
(fn [st]
  (let [[s r] st
        suit-map {\D :diamond \H :heart \C :club \S :spade}
        rank-map {\A 12 \K 11 \Q 10 \J 9 \T 8 \9 7 \8 6 \7 5 \6 4 \5 3 \4 2 \3 1 \2 0}]
    {:suit (suit-map s)
     :rank (rank-map r)}))


;; _artem_uv's solution:
#(let [a % suit {:D :diamond :S :spade :H :heart :C :club} rank {:2 0 :3 1 :4 2 :5 3 :6 4 :7 5 :8 6 :9 7 :T 8 :J 9 :Q 10 :K 11 :A 12}]
   {:suit ((-> a first str keyword) suit) :rank ((-> a last str keyword) rank)})

;; _pcl's solution:
(fn [[s r]]
  (let
    [suits {\D :diamond, \H :heart, \C :club, \S :spade}
     ranks (zipmap [\2 \3 \4 \5 \6 \7 \8 \9 \T \J \Q \K \A] (range))]
    (hash-map :suit (get suits s) :rank (get ranks r))))

;; aceeca1's solution:
(let [
    parse-rank (into {} (map-indexed #(vector %2 %1) "23456789TJQKA"))
    parse-suit {\H :heart \D :diamond \C :club \S :spade}
    parse-card (fn [x] {:suit (parse-suit (first x)) :rank (parse-rank (second x))})]
    parse-card)

;; adereth's solution:
(fn [lp]
  (let [suit (condp = (first lp)
               \S :spade
               \H :heart
               \D :diamond
               \C :club)
        rank (condp = (second lp)
               \2 0
               \3 1
               \4 2
               \5 3
               \6 4
               \7 5
               \8 6
               \9 7
               \T 8
               \J 9
               \Q 10
               \K 11
               \A 12)]
    {:suit suit :rank rank}))

;; 0x89's solution:
(#(fn [[a b]]
  {:suit (% a) :rank (if (% b) (% b) (- (int b) 50))}
  )
(zipmap "DHCTJQKA" [:diamond :heart :club 8 9 10 11 12]))