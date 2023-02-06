(ns learn-clojure.euler-5-test
   (:require [clojure.test :refer [deftest is testing]]
             [learn-clojure.euler-5 :as eul]))

(deftest divide-by-common-factors
  (testing "no matching dividers" 
    (is (= 8 (eul/divide-by-common-factors {3 2} 8))))
  (testing "1 matching divider"
    (is (= 4 (eul/divide-by-common-factors {2 1, 3 2} 8))))
  (testing "2 matching same dividers"
    (is (= 2 (eul/divide-by-common-factors {2 2, 3 2} 8))))
  (testing "2 matching different dividers"
    (is (= 2 (eul/divide-by-common-factors {2 1, 5 1, 7 1} 20))))
  (testing "more matching dividers than actual in number"
    (is (= 5 (eul/divide-by-common-factors {2 5} 20))))) 

(deftest add-to-selected
  (testing "add"
    (is (= {2 1, 3 2} (eul/join-maps {3 1} {2 1, 3 1}))))) 

(deftest product
  (testing "Create product from given factor quantities"
    (is (= 90 (eul/product {2 1, 3 2, 5 1})))))

(deftest get-prime-factors
  (testing "20"
   (is (= {2 2, 5 1} (eul/get-prime-factors 20))))) 

(deftest smallest-multiple
  (testing "example"
    (is (= 2520 (eul/smallest-multiple 1 10))))
  (testing "problem solved"
    (is (= 232792560 (eul/smallest-multiple 1 20)))))
