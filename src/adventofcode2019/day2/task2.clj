(ns adventofcode.day2)

(defn intcode-tinker [noun verb]
  (let [result (nth (intcode-program (opcodes noun verb)) 0)]
    (println (str "Noun is " noun " and verb is " verb ".\nResult: " result))
    result))

(defn task2 []
  (when (= (intcode-tinker 20 3) 19690720)
    (+ (* 100 20) 3)))
