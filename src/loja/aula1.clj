(ns loja.aula1)

(map println["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"])

(println "first:" (first ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println "rest:" (rest ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println "rest[]:" (rest []))
(println "next:" (next ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println "next[]:" (next []))
(println "seq[]:" (seq []))
(println "seq:" (seq [1 2 3 5]))

(println "\n\n--- Meu Mapa - version 1 ---")
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)))


(println "\n\n--- Meu Mapa - version 2: loop infinito---")
;loop infito
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))))


(println "\n\n--- Meu Mapa - version 3: com parada ---")
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))
    ))


(meu-mapa println ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"])
(meu-mapa println ["Daniela" false "Carlos" "Paulo" "Lucia" "Ana"])


(println "\n\n--- Meu Mapa - version 4: com parada do nil ---")
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not  (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))
    ))

(meu-mapa println ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"])
(meu-mapa println ["Daniela" false "Carlos" "Paulo" "Lucia" "Ana"])
(meu-mapa println [])
(meu-mapa println nil)

;(meu-mapa println (range 100000))

(println "\n\n--- Meu Mapa - version 5: com recursão ---")
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not  (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))
    ))

(meu-mapa println (range 6000))








































