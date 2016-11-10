(ns tic-tac-toe.tic-tac-toe-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.tic-tac-toe :refer :all]))

;; run:
;; lein.bat test tic-tac-toe.tic-tac-toe-test
;; lein test tic-tac-toe.tic-tac-toe-test

(def array-after-input
  [[\o nil nil]
   [nil nil nil]
   [nil nil nil]])

(def full-array (repeat 3 (repeat 3 \x)))

(def win (repeat 3 (repeat 3 \x)))

(def horizontal-win
  [[\o \o \o]
   [nil nil nil]
   [nil nil nil]])
(def horizontal-win-second
  [[nil nil nil]
   [\o \o \o]
   [nil nil nil]])
(def horizontal-win-third
  [[nil nil nil]
   [nil nil nil]
   [\o \o \o]])

(def vertical-win
  [[\o nil nil]
   [\o nil nil]
   [\o nil nil]])
(def vertical-win-second
  [[nil \o nil]
   [nil \o nil]
   [nil \o nil]])
(def vertical-win-third
  [[nil nil \o]
   [nil nil \o]
   [nil nil \o]])

(def diagonal-win
  [[\o nil nil]
   [nil \o nil]
   [nil nil \o]])
(def diagonal-win-second
  [[nil nil \o]
   [nil \o nil]
   [\o nil nil]])


(deftest tic-tac-toe-test

  (testing "join-row"
    (is (= (join-row [nil nil nil]) " | | ")))

  (testing "player-input"
    (with-in-str "00"
      (is (= (player-input) {:row 0 :col 0}))))

  (testing "get-array"
    (with-in-str "00"
      (is (= (get-array (player-input)) array-after-input))))

  (testing "change-player"
    (is (= (change-player) \x)))

  (testing "array-full?"
    (is (false? (array-full?)))
    (is (true? (array-full? full-array))))

  (testing "player-win"
    (is (true? (player-char? \o)))
    (is (false? (player-char? \x)))

    (is (true? (horizontal-line? horizontal-win)))
    (is (true? (horizontal-line? horizontal-win-second)))
    (is (true? (horizontal-line? horizontal-win-third)))

    (is (= (transpose horizontal-win) vertical-win))

    (is (true? (vertical-line? vertical-win)))
    (is (true? (vertical-line? vertical-win-second)))
    (is (true? (vertical-line? vertical-win-third)))

    (is (true? (diagonal-line? diagonal-win)))
    (is (true? (diagonal-line? diagonal-win-second)))

    (is (false? (player-win?)))
    (is (true? (player-win? horizontal-win)))
    (is (true? (player-win? vertical-win)))
    (is (true? (player-win? diagonal-win))))

  (testing "game-end?"
    (is (false? (game-end?)))
    (is (true? (game-end? full-array))))

  (testing "player-input-random"
    (is (true? (in-range? 0 2 0)))

    (is (true? (in-range? 0 2 (random-int 0 2))))

    (let [input (player-input-random)]
      (is (true? (and (in-range? 0 2 (input :row))
                      (in-range? 0 2 (input :col))))))

    (is (= (player-input-hash 0 0) {:row 0 :col 0}))

    (is (= (array-cell horizontal-win 0 0) \o))

    (is (true? (array-cell-empty? horizontal-win 1 0)))
    (is (false? (array-cell-empty? horizontal-win 0 0)))

    (is (false? (array-full? (player-input-random-array))))
    (is (= 2 (player-input-random-array array-after-input) (count (remove nil? (flatten array-after-input)))))

  )
)
