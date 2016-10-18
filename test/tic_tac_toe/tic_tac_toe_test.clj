(ns tic-tac-toe.tic-tac-toe-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.tic-tac-toe :refer :all]))

;; run:
;; lein.bat test tic-tac-toe.tic-tac-toe-test

(deftest tic-tac-toe-test

  (testing "join-row"
    (is (= (join-row [nil nil nil]) " | | ")))

  (testing "player-input"
    (with-in-str "00"
      (is (= (player-input) [0 0]))))
)
