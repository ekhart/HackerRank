(ns tic-tac-toe.tic-tac-toe-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.tic-tac-toe :refer :all]))

;; run:
;; lein.bat test tic-tac-toe.tic-tac-toe-test

(def array-after-input
  [[\o nil nil]
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
)
