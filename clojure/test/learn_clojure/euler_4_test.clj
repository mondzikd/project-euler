(ns learn-clojure.euler-4-test
   (:require [clojure.test :refer [deftest is testing]]
             [learn-clojure.euler-4 :as eul]))

(deftest generate-pairs
  (testing "below 3"
    (is (=
         '([0 0] [1 0] [1 1] [2 0] [2 1] [2 2])
         (eul/generate-pairs 3)))))

(deftest product
  (testing "5 10"
    (is (= 50 (eul/product [5 10])))))

(deftest pallindrome? 
  (testing "101 is pallindrome"
    (is (= true (eul/pallindrome? 101))))
  (testing "102 is not pallindrome"
    (is (= false (eul/pallindrome? 102))))) 

(deftest largest-palindrome-product
  (testing "below 3"
    (is (= 4 (eul/largest-palindrome-product 3))))
  (testing "2 digit"
    (is (= 9009 (eul/largest-palindrome-product 100)))))