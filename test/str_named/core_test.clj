(ns str-named.core-test
  (:require
    [str-named.core :refer [name-or-self str-named]]
    [clojure.test :refer :all]))

(defn- named?
  "Tests if a value is an instance of clojure.lang.Named.
   Returns true if the value is an instance and false otherwise"
  [value]
  (instance? clojure.lang.Named value))

(deftest test-name-or-self
  (testing "With clojure.lang.Named value"
           (let [named-value :keyword]
             (is (named? named-value))
             (is (= (name named-value) (name-or-self named-value)))))
  (testing "With non clojure.lang.Named value"
           (let [unnamed-value 77]
             (is (not (named? unnamed-value)))
             (is (= unnamed-value (name-or-self unnamed-value)))))
  (testing "With nil"
             (is (= nil (name-or-self nil)))))

(deftest test-str-named
  (testing "With clojure.lang.Named value"
           (let [named-value :keyword]
             (is (named? named-value))
             (is (= (str (name named-value)) (str-named named-value)))))
  (testing "With non clojure.lang.Named value"
           (let [unnamed-value 77]
             (is (not (named? unnamed-value)))
             (is (= (str unnamed-value) (str-named unnamed-value)))))
  (testing "With nil"
             (is (= (str nil) (str-named nil))))
  (testing "With mixed values"
             (is (= "10-c-string-symbol-keyword-{}" 
                    (apply str-named (interpose \- [10 \c "string" 'symbol :keyword {}]))))))
