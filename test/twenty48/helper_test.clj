(ns twenty48.helper-test
  (:require [clojure.test :refer :all]
            [twenty48.core :refer :all]))

(deftest splitting-identically
  (testing "two consecutive identical numbers"
    (is (= '((2 2) (4) (8))
           (all-identicals '(2 2 4 8)))))
  (testing "more than two consecutive identical numbers"
    (is (= '((2 2 2 2))
           (all-identicals '(2 2 2 2)))))
  (testing "more than two consecutive identical numbers"
    (is (= '((2 2) (4 4))
           (all-identicals '(2 2 4 4))))))

(deftest spliting-identical-list-by-2
  (testing "split when list has 3 identical numbers"
    (is (= '((2 2) (2))
           (split-by-2 '(2 2 2)))))
  (testing "split when list has all identical numbers"
    (is (= '((2 2) (2 2))
           (split-by-2 '(2 2 2 2))))))

(deftest adding-splitted-list
  (testing "add all elements in list after splitting"
    (is (= '(4 2)
           (add-splitted '(2 2 2)))))
  (testing "split when list has all identical numbers"
    (is (= '(4 4)
           (add-splitted '(2 2 2 2))))))

(deftest add-prepending-zero
  (testing "prepend 1 zeros in list"
    (is (= '(0 4 2 4)
           (prepend-zeros '(2 2 2 4)))))
  (testing "prepend 2 zeros in list"
    (is (= '(0 0 4 4)
           (prepend-zeros '(2 2 2 2)))))
  (testing "prepend 2 zeros in list"
    (is (= '(0 0 0 4)
           (prepend-zeros '(0 0 2 2))))))
