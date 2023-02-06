(ns learn-clojure.euler-2-test
  (:require [clojure.test :refer [deftest is testing]]
            [learn-clojure.euler-2 :as eul]))

(deftest sum-of-even-fibon-numbers
  (testing "under 2"
    (is (= 0 (eul/sum-of-even-fibon-numbers 2))))
  (testing "under 5"
    (is (= 2 (eul/sum-of-even-fibon-numbers 5))))
  (testing "under 40"
    (is (= 44 (eul/sum-of-even-fibon-numbers 40)))))

(deftest sum-of-even-fibon-numbers-v2
  (testing "under 2"
    (is (= 0 (eul/sum-of-even-fibon-numbers-v2 2))))
  (testing "under 5"
    (is (= 2 (eul/sum-of-even-fibon-numbers-v2 5))))
  (testing "under 40"
    (is (= 44 (eul/sum-of-even-fibon-numbers-v2 40)))))

(deftest sum-of-even-fibon-numbers-v3
  (testing "under 2"
    (is (= 0 (eul/sum-of-even-fibon-numbers-v3 2))))
  (testing "under 5"
    (is (= 2 (eul/sum-of-even-fibon-numbers-v3 5))))
  (testing "under 40"
    (is (= 44 (eul/sum-of-even-fibon-numbers-v3 40)))))