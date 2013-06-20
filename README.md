# codebreaker

This is a program meant to assist in solving the first programming exercise found [here](https://class.coursera.org/crypto-007/class/index).

It is written in [Clojure](http://clojure.org/) and can be run from a REPL. I use [Leiningen](https://github.com/technomancy/leiningen).

***I highly encourage you to read the source code to understand how it works. This will give you a better understanding of both Clojure and the underlying cryptographic concepts.***

***The Coursera [honor code](https://www.coursera.org/about/honorcode) prohibits offering solutions to homework, quizzes, or exams. I don't believe this code counts as a solution, but I may pull this repository at any time upon course staff request.***

## Usage

Once you have Leiningen installed, change to the cloned project directory `~/codebreaker` and type:
    
    lein repl

You will get this prompt:

    user=>

To use the functions in `core.clj` and the ciphertexts stored in `ciphertexts.clj` type these commands [1]:

    user=> (require '[codebreaker.core :as cb])
    nil
    user=> (use 'codebreaker.ciphertexts)
    nil

You can use any of the stored ciphertexts by using its name (e.g., `ct1` or `target`). 

To use the functions in `core.clj` you have to prepend it with the alias and a slash `cb/` (e.g., `cb/unhexify`).

To make a candidate key you need to first convert the given ciphertext into a list of decimal values

    user=> (cb/unhexify ct1)
    (49 92 78 234 168 181 248 170 249 23 65 69 191 67 225 120 75 143 160 13 199 29 136 90 128 78 94 233 250 64 177 99 73 193 70 251 119 140 223 45 58 255 2 29 255 245 180 3 181 16 208 208 69 84 104 174 185 134 34 177 55 218 232 87 85 60 205 136 131 167 188 55 82 14 6 229 21 210 44 149 78 186 80 37 184 204 87 238 89 65 140 231 220 107 196 21 86 189 179 107 188 163 232 119 67 1 251 202 163 184 59 34 8 9 86 9 135 129 95 101 40 103 100 112 61 224 243 213 36 64 10 25 177 89 97 11 17 239 62)

From there you can make a candidate key by XOR-ing it with a plaintext string that you think it might correspond to:

    user=> (cb/make-key
      #_=> (cb/plaintext->decimals "Choose your plaintext string wisely!")
      #_=> (cb/unhexify ct1))
    (114 52 33 133 219 208 216 211 150 98 51 101 207 47 128 17 37 251 197 117 179 61 251 46 242 39 48 142 218 55 216 16 44 173 63 218)

Once you have made a candidate key, you can test it against the ciphertexts [2]:

    user=> (cb/test-key
      #_=> '(114 52 33 133 219 208 216 211 150 98 51 101 207 47 128 17 37 251 197 117 179 61 251 46 242 39 48 142 218 55 216 16 44 173 63 218)
      #_=> ct2)
      "Qx#i`+wp{zbor>zcj6gt9'xl=!{3?i;+r{`"

Keep making and testing keys until you are satisfied that the target plaintext is correct.

**Notes:**  
[1]: Ignore `nil`, this is what is returned by the REPL after each command. "footnote"  
[2]: Note that you must quote the key here (e.g., `'(114 ... 218)`), otherwise Clojure tries to read it as a list, which must start with a function.

**Copyright © 2013 Christopher Devine**

**Distributed under the Eclipse Public License, the same as Clojure.**