;; Filter Perfect Squares
;; http://www.4clojure.com/problem/74

;; Difficulty:	Medium
;; Topics:


;; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.


;; (defn __ [s]
;;   (-> (re-seq #"\d+" s)
;;       (map #(Integer/parseInt %))))
;;       (filter #(let [n (Math/sqrt %)] (= (Math/floor n) n)))))

;;   (map #(Integer/parseInt %) (re-seq #"\d+" s)))

;; (= (Math/floor (Math/sqrt 3)) (Math/sqrt 3))


(defn __ [s]
  (apply str
         (interpose ","
                    (filter #(let [n (Math/sqrt %)] (= (Math/floor n) n))
                            (map #(Integer/parseInt %)
                                 (re-seq #"\d+" s))))))



;; (-> (re-seq #"\d+" "4,5,6,7,8,9") map)

(= (__ "4,5,6,7,8,9") "4,9")

(= (__ "15,16,25,36,37") "16,25,36")

;; (join " " [1 2 3 4])


;; 4Clojure copy paste
(fn [s]
  (apply str
         (interpose ","
                    (filter #(let [n (Math/sqrt %)] (= (Math/floor n) n))
                            (map #(Integer/parseInt %)
                                 (re-seq #"\d+" s))))))


;; _artem_uv's solution:
(fn [x] (clojure.string/join #"," (filter #(= % (* (int (Math/sqrt %)) (int (Math/sqrt %)))) (map #(Integer/parseInt %) (clojure.string/split x #",")))))

;; _pcl's solution:
(fn [strs]
  (apply str
    (interpose ","
      (filter
        #(= 0.0 (mod (Math/sqrt %) 1))
        (map #(Integer/parseInt %) (.split strs ","))))))

;; aceeca1's solution:
(fn [x] (apply str (interpose "," (filter (fn [x] (some #{x} (map-indexed * (range x)))) (read-string (str "(" x ")"))))))

;; adereth's solution:
(fn [s]
  (let [nums (map #(Integer/parseInt %) (.split s ","))
        p2 #(* % %)
        sqs (filter (fn [n] (= n (p2 (int (Math/sqrt n))))) nums)]
    (apply str (interpose \, sqs))))