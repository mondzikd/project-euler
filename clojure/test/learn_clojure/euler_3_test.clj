(ns learn-clojure.euler-3-test
  (:require [clojure.test :refer [deftest is testing]]
            [learn-clojure.euler-3 :as eul]))

(deftest largest-prime-factor
  (testing "13195"
    (is (= 29 (eul/largest-prime-factor 13195)))))
