(ns adventofcode.day2
  (:require [clojure.string :as str]))

(def OPCODE-LIST-STEP 4)
(defn opcodes [noun verb] (-> (slurp "src/adventofcode2019/day2/input.txt")
                              str/trim-newline
                              (str/split #",")
                              vec-parse-int
                              (assoc 1 noun 2 verb)))

(defn intcode-program [opcodes]
  (loop [codes opcodes
         idx 0]
    (let [[opcode p1 p2 r1] (subvec codes idx (+ idx OPCODE-LIST-STEP))]
      (cond
        (= opcode 99) codes
        (= opcode 1) (recur (assoc codes r1 (+ (nth codes p1) (nth codes p2))) (+ idx OPCODE-LIST-STEP))
        (= opcode 2) (recur (assoc codes r1 (* (nth codes p1) (nth codes p2))) (+ idx OPCODE-LIST-STEP))))))

(defn vec-parse-int [list]
  (vec (map #(Integer/parseInt %) list)))

(defn task1 []
  (nth (intcode-program (opcodes 12 2)) 0))
