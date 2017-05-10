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
