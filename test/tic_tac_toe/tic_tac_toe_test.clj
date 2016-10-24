(ns tic-tac-toe.tic-tac-toe-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.tic-tac-toe :refer :all]))

;; run:
;; lein.bat test tic-tac-toe.tic-tac-toe-test

(def array-after-input
  [[\o nil nil]
   [nil nil nil]
   [nil nil nil]])

(def full-array (repeat 3 (repeat 3 \x)))

(def win (repeat 3 (repeat 3 \x)))

(def horizontal-win [[\o \o \o]
                     [nil nil nil]
                     [nil nil nil]])



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
    (is (false? (player-win?)))
    (is (true? (player-win? horizontal-win))))
)
