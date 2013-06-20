(ns codebreaker.core-test
  (:require [clojure.test :refer :all]
            [codebreaker.core :refer :all]))

(deftest test-unhexify
	(testing "with numbers"
		(is (= '(48 49 50 51 52 53 54 55 56 57) 
					 	(unhexify "30313233343536373839"))))
	(testing "with lowercase letters"
		(is (= '(97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122)
						(unhexify "6162636465666768696a6b6c6d6e6f707172737475767778797a"))))
	(testing "with uppercase letters")
		(is (= '(65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90)
						(unhexify "4142434445464748494a4b4c4d4e4f505152535455565758595a"))))

(deftest test-plaintext->decimals
	(testing "with numbers"
		(is (= '(48 49 50 51 52 53 54 55 56 57)
						(plaintext->decimals "0123456789"))))
	(testing "with lowercase letters"
		(is (= '(97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122)
						(plaintext->decimals "abcdefghijklmnopqrstuvwxyz"))))
	(testing "with uppercase letters")
		(is (= '(65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90)
						(plaintext->decimals "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))))