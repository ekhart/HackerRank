;; Through the Looking Class
;; http://www.4clojure.com/problem/126

;; Difficulty:	Easy
;; Topics:	fun brain-teaser


;; Enter a value which satisfies the following:

(let [x Class]
  (and (= (class x) x) x))

(= (class true) true)

(= (class nil) nil)
(and (= (class nil) nil) nil)

(= (class '()) '())

;; https://github.com/qiuxiafei/4clojure/blob/master/answers/126.Through the Looking Class
Class