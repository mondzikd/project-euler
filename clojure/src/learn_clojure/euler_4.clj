(ns learn-clojure.euler-4)

;; https://projecteuler.net/problem=4
;; 
;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn generate-pairs [bound]
  (for [a (range bound)
        b (range (inc a))]
    [a b]))

(defn product [[x y]] (* x y))

(defn pallindrome? [num]
  (= (str num) (apply str (reverse (str num)))))

(defn largest-palindrome-product [bound]
  (->> (generate-pairs bound)
       (map product)
       (filter pallindrome?)
       (apply max)))

;; (println (largest-palindrome-product 1000))
