(ns adventofcode.day1
  (:require [clojure.string :as str]))

(defn calc-recur [mass]
  (loop [remainder mass
         sum 0]
    (if (zero? remainder)
      sum
      (let [fuel (-> remainder (quot 3) (- 2) (max 0))]
        (recur fuel (+ sum fuel))))))

(defn task2 []
  (reduce #(+ %1 (calc-recur (Integer/parseInt %2)))
          0
          (str/split (slurp "src/adventofcode2019/day1/input.txt") #"\n")))

