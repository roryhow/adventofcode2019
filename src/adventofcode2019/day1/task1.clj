(ns adventofcode.day1
  (:require [clojure.string :as str]))

(defn task1 []
  (reduce #(+ %1 (-> (Integer/parseInt %2) (/ 3) Math/floor (- 2)))
          0
          (str/split (slurp "src/adventofcode2019/day1/input.txt") #"\n")))



