(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))
(println "\n Aula 05 - Keep, filter eo mundo estranho das sequencias infinitas\n")


(println "/nVersion - 1")
(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep:" (keep gastou-bastante? resumo))
  (println "filter:" (filter gastou-bastante? resumo)))


(println "\nVersion - 2")

(defn gastou-bastante? [info-do-usuario]
  (println "gastou-bastante?" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep:" (keep gastou-bastante? resumo)))


(println "\nVersion - 3")

(println (range 10))
(println (take 2 (range 10000000000000000000)))
; a sequência não esta sendo "gulosa" (eager)
(let [sequencia (range 100000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia)))                             ;imutabilidade
; Esta sendo lazy (preguiçosa)

(println "\nVersion - 4")

(defn filtro1 [x]
  (println "Filtro 1:" x)
  x)

(defn filtro2 [x]
  (println "Filtro 2:" x)
  x)

(println (map filtro2 (map filtro1 (range 10))))

(println "\nVersion - 5")

(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)

(println "\nVersion - 6")
;chunks de 32
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

(println "\nVersion - 7")

(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

(println "\nVersion - 8")

(->> [0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9]
     (map filtro1)
     (map filtro2)
     println)

(println "\nVersion - 9")
; lista ligada foi 100% lazy nesse cenáriol
(->> '(0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9)
     (map filtro1)
     (map filtro2)
     println)
