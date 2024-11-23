(ns testing-samples.core
  (:require [schema.core :as s]))

(s/defn sum :- s/Num
  [sum-number-1 :- s/Num
   plus-number-2 :- s/Num]
  (+ sum-number-1 plus-number-2))
