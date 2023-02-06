(ns learn-clojure.euler-6)

;; https://projecteuler.net/problem=6
;; 
;; Find the difference between the sum of the squares of the first one hundred natural numbers
;; and the square of the sum.

(defn sum-of-squares [n]
  (/
   (* n (+ n 1) (+ (* 2 n) 1))
   6))

(defn square-of-sum [n]
  (let [sum (/ (* n (+ n 1)) 2)]
    (* sum sum)))

(defn difference [n]
  (- (sum-of-squares n) (square-of-sum n)))

;; (println (time (difference 100)))
