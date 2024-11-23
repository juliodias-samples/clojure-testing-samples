(ns testing-samples.core-test
  (:require [clojure.test :refer :all]
            [matcher-combinators.test]
            [matcher-combinators.matchers :as m]
            [testing-samples.core :refer :all]))

(deftest simple-sum-test
  (testing "sum 2 + 2 should return 4"
    (is (= 4 (sum 2 2)))))

(deftest sum-with-are-test
  (testing "sum multiple expressions should return the correct result"
    (are [result number1 number2]
      (is (= result (sum number1 number2)))
      2 1 1
      10 5 5
      20 10 10
      100 50 50)))

(deftest sum-number-is-true-test
  (testing "should return true when asked if the result is a number"
    (is (number? (sum 5 6)))))

(deftest sum-throwing-exception-test
  (testing "should throw ClassCastException when a invalid number is passed"
    (is (thrown? ClassCastException (sum "2" "10")))))

; Assertions below using the matcher combinators

(deftest sum-with-matcher-combinators-test
  (testing "simple sum using matcher combinators"
    (is (match? (m/equals 100) (sum 50 50)))))

(deftest nested-structure-test
  (testing "should match the structure"
    (is (match? {:person/name "John Doe"
                 :person/age  100}
                {:person/name "John Doe"
                 :person/age  100}))
    (is (match? {:person {:name "John Doe"
                          :age  100}}
                {:person {:name "John Doe"
                          :age  100}}))))
