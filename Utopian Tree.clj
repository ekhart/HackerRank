(use '[clojure.string :only (split triml)])

(defn spring [h]
  (* h 2))

(def summer inc)

(defn tree-cycle [h i]
  (if (odd? i)
    (summer h)
    (spring h)))

; Redefining a let'd variable in Clojure loop
; http://stackoverflow.com/questions/940712/redefining-a-letd-variable-in-clojure-loop
;(defn height [n]
;  (let [h 1]
;    (dotimes [i n]
;      (set! h (cycle h)))
;     h))

; https://clojuredocs.org/clojure.core/loop
(defn height [n]
  (loop [i 0
         h 1]
    (if (< i n)
      (recur (inc i)
             (tree-cycle h i))
      h)))

(
        let [
          t_t (read-line)
          t (Integer/parseInt t_t)

          h 1
        ]

      (
        loop [a0 t]
        (when (> a0 0)

          (
            let [
              n_t (read-line)
              n (Integer/parseInt n_t)
            ]

            (println (height n))
          )

        (recur (- a0 1) ) )
      )

)
