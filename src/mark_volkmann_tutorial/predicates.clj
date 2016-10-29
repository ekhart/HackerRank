;; Predicates
;; http://java.ociweb.com/mark/clojure/article.html#Predicates

;; predicates return true | false
;; false, nil -> true
;; others -> true (even 0)
;; have name with ?

;; reflection: info about object other than its value
;; single object: class? coll? decimal? delay? float? fn? instance? integer? isa? keyword? list? macro? map? number? seq? set? string? vector?
;; non-predicate reflection: ancestors, bases, class, ns-publics, parents

;; testing relationships: < <= = not= == > >= compare distinct? identical?
;; logic relations: and or not true? false? nil?

;; sequences: empty? not-empty? every? not-every? some not-any?

;; numbers: even? neg? odd? pos? zero?