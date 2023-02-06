(ns learn-clojure.euler-5)

;; https://projecteuler.net/problem=5
;; 
;; What is the smallest positive number that is evenly divisible
;; by all of the numbers from 1 to 20?

(defn- divide-with-no-reminder [dividend [divisor quantity]]
  (loop [result dividend
         times 0]
    (if (and (> quantity times) (= 0 (mod result divisor)))
      (recur (/ result divisor) (inc times))
      result)))

(defn divide-by-common-factors [divisors dividend]
  (reduce
   divide-with-no-reminder
   dividend
   divisors))

(defn join-maps [first-map second-map]
  (reduce
   (fn [joined [key value]] (update joined key #(if % (+ % value) value)))
   first-map
   second-map))

(defn get-prime-factors [number]
  (loop [prime-factors {}
         dividend number
         divisor 2]
    (if (= 1 dividend)
      prime-factors
      (if (= 0 (mod dividend divisor))
        (recur (join-maps prime-factors {divisor 1}) (/ dividend divisor) divisor)
        (recur prime-factors dividend (inc divisor))))))

(defn product [factors]
  (reduce
   (fn [product [factor quantity]] (apply * product (repeat quantity factor)))
   1
   factors))

(defn smallest-multiple [a b]
  (loop [required-prime-dividers {}
         current-number b]
    (if (> a current-number)
      (product required-prime-dividers)
      (recur
       (->> (divide-by-common-factors required-prime-dividers current-number)
            (get-prime-factors)
            (join-maps required-prime-dividers))
       (dec current-number)))))

;; (println (smallest-multiple 1 20))
