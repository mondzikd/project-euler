(ns learn-clojure.euler-3)

;; https://projecteuler.net/problem=3
;;
;; What is the largest prime factor of the number 600851475143 ?

(defn largest-prime-factor [n]
  (loop [max 2
         i 2
         m n]
    (if (> (* i i) m)
      (if (> max m) max m)
      (if (= 0 (mod m i))
        (recur i i (/ m i))
        (recur max (inc i) m)))))

;; (println (largest-prime-factor 600851475143))
