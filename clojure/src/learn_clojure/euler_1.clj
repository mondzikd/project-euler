(ns learn-clojure.euler-1)

;; https://projecteuler.net/problem=1
;;
;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;;
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn sum-of-arithmetic-series [a n] (* a n (/ (+ n 1) 2)))

(defn elements-number [a bound]
  (if (= 0 (mod bound a))
    (dec (/ bound a))
    (int (/ bound a))))

(defn sum-of-multiples
  [x y bound]
  (- 
   (+ 
    (sum-of-arithmetic-series x (elements-number x bound)) 
    (sum-of-arithmetic-series y (elements-number y bound))) 
   (sum-of-arithmetic-series (* x y) (elements-number (* x y) bound))))

;; (println (sum-of-multiples 3 5 1000))
