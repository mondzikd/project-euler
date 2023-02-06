(ns learn-clojure.euler-1-test
  (:require [clojure.test :refer [deftest is testing]]
            [learn-clojure.euler-1 :as eul]))

(deftest sum-of-arithmetic-series-test 
  (testing "3 3" 
    (is (= 18 (eul/sum-of-arithmetic-series 3 3))))) 

(deftest elements-number-test
  (testing "3 10"
    (is (= 3 (eul/elements-number 3 10))))
  (testing "5 10"
    (is (= 1 (eul/elements-number 5 10)))))

(deftest sum-of-multiples-test
  (testing "3 5 10"
    (is (= 23 (eul/sum-of-multiples 3 5 10))))
  (testing "3 5 11"
    (is (= 33 (eul/sum-of-multiples 3 5 11))))
  (testing "3 5 16"
    (is (= 60 (eul/sum-of-multiples 3 5 16)))))