(ns learn-clojure.euler-6-test
  (:require [clojure.test :refer [deftest is testing]]
            [learn-clojure.euler-6 :as eul]))

(deftest square-of-sum
  (testing "1"
    (is (= 1 (eul/square-of-sum 1))))
  (testing "2"
    (is (= 9 (eul/square-of-sum 2)))))

(deftest sum-of-squares
  (testing "1"
    (is (= 1 (eul/sum-of-squares 1))))
  (testing "2"
    (is (= 5 (eul/sum-of-squares 2)))))

(deftest sum-of-even-fibon-numbers
  (testing "10"
    (is (= -2640 (eul/difference 10)))))
