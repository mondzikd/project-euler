(ns learn-clojure.core
  (:use [criterium.core :only (bench)])
  ;;  (:require [learn-clojure.euler-2 :refer [sum-of-even-fibon-numbers
  ;;                                          sum-of-even-fibon-numbers-v2
  ;;                                          sum-of-even-fibon-numbers-v3]]) 
  (:require [learn-clojure.euler-7 :as clj-7]))
  

;; (defn -main [& args]
;;   (bench (sum-of-even-fibon-numbers 4000000))
;;   (bench (sum-of-even-fibon-numbers-v2 4000000))
;;   (bench (sum-of-even-fibon-numbers-v3 4000000)))

(set! *warn-on-reflection* true)
(set! *unchecked-math* :warn-on-boxed)

(defn -main [& args]
  (bench (clj-7/erato-sieve-java-array 1000))
  (bench (clj-7/erato-brute-force 1000)))
