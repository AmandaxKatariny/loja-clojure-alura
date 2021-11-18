(ns loja.aula2)

;["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]

(println "\nCONTA - Version 1")
(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora)
         (rest elementos)))

;(println (conta 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))

(println "\nCONTA - Version 2")
(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora)
           (rest elementos))))

(println (conta 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))


(println "\nCONTA - Version 3")
(defn conta
  [total-ate-agora elementos]
  (println total-ate-agora elementos)
  (if (next elementos)
    (recur (inc total-ate-agora)
           (next elementos))
    total-ate-agora))

(println (conta 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))

(println "\nCONTA - Version 4")
(defn conta
  [total-ate-agora elementos]
  (println total-ate-agora elementos)
  (if (seq elementos)
    (recur (inc total-ate-agora)
           (next elementos))
    total-ate-agora))

(println (conta 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (conta 0 []))

;poli-função cuja invocação é definida de acordo com o número de parâmetros.
; Trata-se de uma maneira de conferir maior flexibilidade às formas.
(defn minha-funcao
     ([parametro1] (println "p1" parametro1))
     ([parametro1 parametro2]
      (println "p2" parametro1 parametro2)))
(minha-funcao 1)
(minha-funcao 1 2)

(println "\n\nCONTA - Version 5")
(defn conta

  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
   ;(println "antes da recorrencia")
   (if (seq elementos)
      (recur (inc total-ate-agora) (next elementos))
    total-ate-agora)))

(println (conta ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (conta []))

(println "\n\nCONTA - Version 6")
(defn conta
  [elementos]
  ;(println "antes do loop")
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println (conta ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (conta []))






























