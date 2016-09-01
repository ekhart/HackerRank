(ns hackerrank.even-tree-test
  (:require [clojure.test :refer :all]
            [hackerrank.even-tree :refer :all])
  (:use [clojure.string :only (split join)]))

; run test in bash for git/cygwin
; lein.bat test hackerrank.even-tree-test

(def test-string-input "10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8")
(def simple-tree '(1 (2)))
(def more-complex-tree '(1 (2) (3)))

(deftest even-tree-test

  (testing "parseInt"
    (is (= (parseInt "1") 1)))

  (testing "numbers"
    (is (= (numbers "10 9") [10 9])))

  (testing "tree"
    (is (= (make-tree) '())))

  (testing "tree-add-edge"
    (is (= (tree-add-edge (make-tree) 2 1) simple-tree))
    (is (= (tree-add-edge simple-tree 3 1) more-complex-tree))
    (is (= (tree-add-edge more-complex-tree 6 1) '(1 (2) (3) (6)))))

  (testing "even-tree"
    (is (= (even-tree test-string-input) 9)))

)
