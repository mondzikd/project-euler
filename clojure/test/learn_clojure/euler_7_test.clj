(ns learn-clojure.euler-7-test 
  (:require [clojure.test :refer [deftest is testing]]
            [learn-clojure.euler-7 :as eul])
  (:import [java.util Arrays]))

(deftest prime?
  (testing "1"
    (is (= false (eul/prime? 1))))
  (testing "2"
    (is (= true (eul/prime? 2))))
  (testing "9"
    (is (= false (eul/prime? 9))))
  (testing "13"
    (is (= true (eul/prime? 13)))))

(deftest erato-brute-force-test
  (testing "6th prime"
    (is (= 13 (eul/erato-brute-force 6)))))

(deftest generate-initial-sieve-test
  (testing "sieve up to number 3"
    (is (=
         (eul/generate-initial-sieve 3)
         [false false true true]))))

(deftest remove-primes-test
  (testing "2 3 4 5 6"
    (is (=
         (eul/remove-primes 2 [false false true true true true true])
         [false false true true false true false]))))

(deftest next-prime-test
  (testing "next after 3"
    (is (=
         (eul/next-prime 3 [false false true true false true])
         5)))
  (testing "next after 3 with java sieve"
    (is (=
         (eul/next-prime 3 (boolean-array [false false true true false true]))
         5))))

(deftest erato-sieve-v3-test
  (testing "6th prime"
    (is (= 13 (eul/erato-sieve-v3 6)))))

(deftest next-prime-java-array-test
  (testing "next after 3 with java sieve"
    (is (=
         (eul/next-prime-java-array 3 (boolean-array [false false true true false true]))
         5))))

(deftest generate-initial-java-array-sieve-test
  (testing "creates java boolean array"
    (is (Arrays/equals
         (eul/generate-initial-java-array-sieve 3)
         (boolean-array [false false true true])))))

(deftest remove-primes-java-array-test
  (testing "2 3 4 5 6"
    (is (Arrays/equals
         (eul/remove-primes-java-array 2 (boolean-array [false false true true true true true]))
         (boolean-array [false false true true false true false]))))
  (testing "returns same array object"
    (is
     (let [array (boolean-array [false false true])]
       (=
         (eul/remove-primes-java-array 2 array)
         array)))))