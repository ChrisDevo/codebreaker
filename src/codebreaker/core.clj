(ns codebreaker.core)

(defn unhexify [hex]
	(map 
      (fn [[x y]] (Integer/parseInt (str x y) 16)) 
      (partition 2 hex)))

(defn plaintext->decimals [string]
	(map int string))

(defn make-key [pt-decimals ct-decimals]
	(map bit-xor pt-decimals ct-decimals))