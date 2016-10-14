(use '[clojure.pprint :only (pprint)])
(use '[clojure.string :only (join)])

;; 2 players: X, O

;; 1 random how start: x or o
;; 2 show clear table
;; 3 get player input: where to put its char
;; 4 check if player win

(def array [[nil nil nil] [nil nil nil] [nil nil nil]])   ; todo - how to auto generate it
;; (clojure.pprint/pprint arry)

(def arry (make-array Integer/TYPE 3 3))
;; (pprint arry)

;; (for [_ (range 3)] [nil nil nil])
(for [_ (range 3)] (for [_ (range 3)] nil))

; o|o|o
; -----
; o|o|o
; -----
; o|o|o
;; (defn print-tabl [table]
;;   (doseq [row table]
;;     (println
;;       (join "|"
;;             (map #(if (nil? %) " " %) row)))))

(defn join-row [row]
  (join "|" (map #(if (nil? %) " " %) row)))

(defn print-tabl [table]
  (map #(join "-----\n" (join-row %)) table))

(print (print-tabl array))