;; intoCamelCase
;; http://www.4clojure.com/problem/102 
;; Difficulty:	Medium
;; Topics:	strings

;; When working with java, you often need to create an object with fieldsLikeThis, but you'd rather work with a hashmap that has :keys-like-this until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.

(defn __ [s]
  (let [ss (clojure.string/split s #"-")
      f (first ss)
      r (rest ss)
      rc (map clojure.string/capitalize r)]
    (apply str (concat f rc))))

(= (__ "something") "something")

(= (__ "multi-word-key") "multiWordKey")

(= (__ "leaveMeAlone") "leaveMeAlone")


(split-with (partial = \-)  "multi-word-key")

(let [ss (clojure.string/split "multi-word-key" #"-")
      f (first ss)
      r (rest ss)
      rc (map clojure.string/capitalize r)]
  (apply str (concat f rc)))


;; copy paste solution
(fn __ [s]
  (let [ss (clojure.string/split s #"-")
      f (first ss)
      r (rest ss)
      rc (map clojure.string/capitalize r)]
    (apply str (concat f rc))))


;; others
;; _artem_uv's solution:
#(apply str (into [(first (clojure.string/split % #"-"))] (map clojure.string/capitalize  (rest (clojure.string/split % #"-")))))

;; _pcl's solution:
(fn [s]
  (letfn
    [(ucfirst [w] (apply str (-> w first str .toUpperCase) (rest w)))]
      (let
        [words (re-seq #"[a-zA-Z]+" s)]
          (apply str (first words) (map ucfirst (rest words))))))

;; aceeca1's solution:
#(clojure.string/replace % #"-[a-z]" (comp clojure.string/upper-case last))

;; adereth's solution:
(fn [dashed]
  (let [tokens (.split dashed "-")
        capped (map #(apply str (Character/toUpperCase (first %))
                          (rest %)) (rest tokens))]
  (apply str (first tokens) capped)))

;; 0x89's solution:
(fn [w] (let [s (.split w "-")]
           (apply str (first s)      
                  (map                  
                    #(apply str
                            (char (- (int (first %)) 32))
                            (rest %))
                    (rest s)))))
