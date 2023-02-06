(ns learn-clojure.euler-7)

;; https://projecteuler.net/problem=7
;; 
;; What is the 10 001st prime number?

(set! *warn-on-reflection* true)
(set! *unchecked-math* :warn-on-boxed)

(defn erato-sieve [n]
  (reduce
   (fn [res idx]
     (if (= n (inc idx))
       (first res)
       (filterv #(not= 0 (mod % (first res))) res)))
   (range 2 (* 12 n))
   (range n)))

(defn- remove-multiples [factor numbers]
  (filterv #(not= 0 (mod % factor)) numbers))

(defn erato-sieve-v2 [n]
  (loop [i 1
         numbers (range 2 (* 12 n))]
    (if (= [] numbers)
      "Not found. Give bigger starting range :)"
      (let [current-prime (first numbers)]
        (if (= n i)
          current-prime
          (recur (inc i) (remove-multiples current-prime numbers)))))))

(defn generate-initial-sieve [number]
  (vec (concat [false false] (repeat (dec number) true))))

(defn remove-primes [prime sieve]
  (loop [i (* prime prime)
         new-sieve sieve]
    (if (> i (count sieve))
      new-sieve
      (recur (+ i prime) (assoc new-sieve i false)))))

(defn next-prime ^long [current-prime sieve]
  (first
   (keep-indexed
    #(when (true? %2) (+ 1 current-prime %1))
    (drop (inc current-prime) sieve))))

(defn erato-sieve-v3 [n]
  (loop [i 1
         prime 2
         sieve (generate-initial-sieve (* 12 n))]
    (if (= i n)
      prime
      (recur (inc i) (next-prime prime sieve) (remove-primes prime sieve)))))

(defn generate-initial-java-array-sieve [n] (boolean-array (generate-initial-sieve n)))

(defn next-prime-java-array ^long [^long current-prime ^booleans sieve]
  (loop [i (inc current-prime)]
    (if (= true (aget sieve i))
      i
      (recur (inc i)))))

(defn remove-primes-java-array [^long prime ^booleans sieve] ;; What is the difference between #^ and ^?
  (loop [i (* prime prime)]
    (if (>= i (alength sieve))
      sieve
      (do (aset sieve i false) (recur (+ i prime))))))

(defn erato-sieve-java-array [^long n]
  (let [sieve (generate-initial-java-array-sieve (* 12 n))]
     (loop [i 1 prime 2]
       (if (= i n)
         prime
         (do
           (remove-primes-java-array prime sieve)
           (recur (inc i) (next-prime-java-array prime sieve)))))))

(defn prime? [number]
  (if (= 1 number)
    false
    (loop [i 2]
      (if (> (* i i) number)
        true 
        (if (= 0 (mod number i))
          false
          (recur (inc i)))))))

(defn erato-brute-force [n]
  (loop [i 2
         prime-counter 0]
    (if (prime? i)
      (if (= (inc prime-counter) n)
        i
        (recur (inc i) (inc prime-counter)))
      (recur (inc i) prime-counter))))

;; (println
;;  (time (erato-sieve 10001))
;;  (time (erato-sieve-v2 10001))
;;  (time (erato-sieve-v3 10001))
;;  (time (erato-brute-force 10001))
;;  (time (erato-sieve-java-array 10001)))
