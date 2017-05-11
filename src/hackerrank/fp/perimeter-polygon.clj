;; Compute the Perimeter of a Polygon
;; https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon

;; compute distance between all pairs of points
;; sum them up = answer
;; 1. distance between 2 points
;; https://www.mathsisfun.com/algebra/distance-2-points.html

(def point vector)
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

(def input [[0 0]
            [0 1]
            [1 1]
            [1 0]])

;; (reduce #(+ %1 (distance )))

(def input 
"4\n
0 0\n
0 1\n
1 1\n
1 0")

(with-in-str input
  (let [n (Integer/parseInt (read-line))]
    (println n)
    (dotimes [_ n]
      (let [line (read-line)
            numbers (map #(Integer/parseInt (str %)) 
                         (take-nth 2 (vec (read-line))))]
        (println numbers)))))

(map #(Integer/parseInt (str %)) (take-nth 2 (vec "1 0")))

