;; Intro to Destructuring 2
;; http://www.4clojure.com/problem/173

; wtf?
(= 3
  (let [[_] [+ (range 3)]] (apply _))
  (let [[_] b] [[+ 1] 2]] (_ b))
  (let [[_] [inc 2]] (_)))



;; http://clojure.org/guides/destructuring
;; http://clojure.org/reference/special_forms#Special%20Forms--(let%20[bindings*%20]%20exprs*)

;; solutions:
;; https://github.com/qiuxiafei/4clojure
