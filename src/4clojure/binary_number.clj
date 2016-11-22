;; Read a binary number
;; http://www.4clojure.com/problem/122

;; Difficulty:	Easy
;; Topics:


;; Convert a binary number, provided in the form of a string, to its numerical value.


(defn __ [s]
  (int (reduce +
          (map #(* (Math/pow 2 (first %)) (second %))
               (map-indexed #(vector %1 (Integer/parseInt %2))
                            (remove clojure.string/blank? (reverse (clojure.string/split s #""))))))))

(flatten (partition 1 "111"))
;; (map-indexed #((Math/pow 2 %2) Integer/parseInt (str %1)) (flatten (partition 1 "111")))

;; (map-indexed #(fn [idx itm] (Math/pow 2 idx)) [1 1 1])
(reduce + (map #(* (Math/pow 2 (first %)) (second %)) (map-indexed vector [1 0 1])))

(Math/pow 2 1)


(= 0     (__ "0"))

(= 7     (__ "111"))

(= 8     (__ "1000"))

(= 9     (__ "1001"))

(= 255   (__ "11111111"))

(= 1365  (__ "10101010101"))

(= 65535 (__ "1111111111111111"))



;; 4clojure copy paste
(fn [s]
  (int (reduce +
          (map #(* (Math/pow 2 (first %)) (second %))
               (map-indexed #(vector %1 (Integer/parseInt %2))
                            (remove clojure.string/blank? (reverse (clojure.string/split s #""))))))))


;; _artem_uv's solution:
#(Integer/parseInt % 2)

;; _pcl's solution:
(fn [s] (reduce + (map-indexed #(if (= %2 \0) 0 (bit-shift-left 1 %1)) (reverse s))))

;; aceeca1's solution:
reduce #(+ %1 %1 (- (int %2) 48)) 0

;; adereth's solution:
#(Integer/parseInt % 2)