;; Compute the Perimeter of a Polygon
;; https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon

;; compute distance between all pairs of points
;; sum them up = answer
;; 1. distance between 2 points
;; https://www.mathsisfun.com/algebra/distance-2-points.html

(def point vector)

(defn point
  ([v] (vector (first v) (second v)))
  ([a b] (vector a b)))

(def x first)
(def y second)
;; https://clojuredocs.org/clojure.core/memfn
;; (def sqrt (memfn Math/sqrt number))
;; (memfn Math/sqrt)

(def p (point 1 2))
(x p)
(y p)

(Math/sqrt 4)

(defn square [n]
  (* n n))

(defn distance [a b]
  (Math/sqrt (+ (square (- (x a) (x b)))
                (square (- (y a) (y b))))))

(distance (point 0 0) (point 0 1)) ; => 1

(point [0 0])

(def input [[0 0]
            [0 1]
            [1 1]
            [1 0]])

(drop 1 (take 5 (cycle input)))
(drop 1 input)

;; (partition 2 (interleave input (drop 1 (take 5 (cycle input)))))
;; main solution
(->> (cycle input)
     (take 5)
     (drop 1)
     (interleave input)
     (partition 2)
     (reduce #(+ %1 (distance (first %2) (second %2))) 0))

(defn solution [input]
  (->> (cycle input)
       (take 5)
       (drop 1)
       (interleave input)
       (partition 2)
       (reduce #(+ %1 (distance (first %2) (second %2))) 0)))

;; (reduce #(+ %1 (distance % )) (take 5 (cycle input)))

;; (def input 
;; "4\n
;; 0 0\n
;; 0 1\n
;; 1 1\n
;; 1 0")

(def input
"3\n
1043 770\n
551 990\n
681 463\n")

(with-in-str input
  (let [n (Integer/parseInt (read-line))]
    (println n)
    (dotimes [_ n]
      (let [line (read-line)
            numbers (map #(Integer/parseInt (str %)) 
                         (take-nth 2 (vec (read-line))))]
        (println numbers)))))

(defn parseInt [n]
  (Integer/parseInt (str n)))

(defn parseInt-at [f coll]
  (parseInt (f coll)))

;; https://clojuredocs.org/clojure.core/line-seq
(import '(java.io BufferedReader StringReader))
(line-seq (BufferedReader. (StringReader. input)))

(->> input
     StringReader.
     BufferedReader.
     line-seq
     (drop 1)
     (filter #(pos? (count %)))
     (map #(vec %))
     (map #(partition-by (partial = \space) %))
     (mapcat #(remove (partial = [\space]) %))
     (map #(apply str %))
     (partition 2)
     (map #(vector (parseInt-at first %) (parseInt-at second %)))
     solution)

(->> (partition-by #(= % \space) [\1 \0 \4 \3 \space \7 \7 \0])
     (remove #(= % [\space]))
     (map #(apply str %)))



(count "1")

;; todo: gather input in list 
;; then call on it (solution input)

;; (map #(Integer/parseInt (str %)) (take-nth 2 (vec "1 0")))


;; almost working hackerrank copy paste
; Enter your code here. Read input from STDIN. Print output to STDOUT
(def point vector)

(defn point
  ([v] (vector (first v) (second v)))
  ([a b] (vector a b)))

(def x first)
(def y second)

(defn square [n]
  (* n n))

(defn distance [a b]
  (Math/sqrt (+ (square (- (x a) (x b)))
                (square (- (y a) (y b))))))

;; main solution
(defn solution [input]
  (->> (cycle input)
       (take 5)
       (drop 1)
       (interleave input)
       (partition 2)
       (reduce #(+ %1 (distance (first %2) (second %2))) 0)))

(defn parseInt [n]
  (Integer/parseInt (str n)))

(defn parseInt-at [f coll]
  (parseInt (f coll)))

(import '(java.io BufferedReader StringReader))

(print (->> *in*
            BufferedReader.
            line-seq
            (drop 1)
            (filter #(pos? (count %)))
            (map #(vec %))
            (map #(partition-by (partial = \space) %))
            (mapcat #(remove (partial = [\space]) %))
            (map #(apply str %))
            (partition 2)
            (map #(vector (parseInt-at first %) (parseInt-at second %)))
            solution))

