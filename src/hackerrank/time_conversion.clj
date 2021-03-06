;; Time Conversion
;; https://www.hackerrank.com/challenges/time-conversion

(ns hackerrank.time-conversion
	(:require [clojure.java.io :as io])
  (:use [clojure.string :only (split join)]))

(defn substr? [str substr]
  (boolean
    (re-find substr str)))

(defn pm? [str]
  (substr? str #"PM"))

(defn am? [str]
  (substr? str #"AM"))

(defn time-parts [time]
  (split time #":"))

(defn hour [time]
  (Integer/parseInt (first (time-parts time))))

(defn format-hour [time]
  (format "%02d" (hour time)))

(defn remove-am-pm [time]
  (subs time 0 (- (count time) 2)))

(defn pm-time [time]
  (let [hours (+ (hour time) 12)
        minutes-and-seconds (rest (time-parts time))]
    (join ":" (cons hours minutes-and-seconds))))

(defn hour-time [hours time]
   (join ":" (cons hours (rest (time-parts time)))))

(defn format-24h [time]
  (if (and (pm? time) (not (= (hour time) 12)))
    (remove-am-pm (pm-time time))
    (remove-am-pm time)))

(defn pm-am-time [time]
  (let [hours (hour time)
        time24 (cond
          (and (pm? time) (not= hours 12)) (hour-time (+ hours 12) time)
          (and (am? time) (= hours 12)) (hour-time "00" time)
          :else time)]
    (remove-am-pm time24)))

(defn time-conversion [line]
  (pm-am-time line))

;; (println (time-conversion "07:05:45PM"))
;; for hackerrank
;; (println (time-conversion (read-line)))

;; 2016-08-03 13:50 run at hackerrank: 7/10 solution - 3 fails
;; o preper more test cases
