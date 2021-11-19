(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))
(println "\n Aula 04 - Ordenação, reverse, Extraindo lógica de funções puras \n")

(println (l.db/todos-os-pedidos))

;(println (l.logic/resumo-por-usuario (l.db/todos-os-pedidos)))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "resumo:" resumo)
  (println "ordenado:" (sort-by :preco-total resumo))
  (println "ordenado ao contrario:" (reverse (sort-by :preco-total resumo)))
  (println "ordernado por id:" (sort-by :usuario-id resumo))

  ;update-in, assoc-in
  (println (get-in pedidos [0 :itens :mochila :quantidade])))

(defn resumo-por-usuario-ordenado [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(println "Version 1")
(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "resumo:" resumo)
  (println "primeiro:" (first resumo))
  (println "segundo:" (second resumo))
  (println "resto:" (rest resumo))
  (println "total:" (count resumo))
  (println "class:" (class resumo))
  (println "nth 1:" (nth resumo 1))
  (println "get 1:" (get resumo 1)))

(println "\nVersion 2")

(defn top-2
  "lista top 2"
  [resumo]
  (take 2 resumo))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "resumo:" resumo)
  (println "take:" (top-2 resumo)))

(println "\nVersion 3")

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "> 500 filter:" (filter #(> (:preco-total %) 500) resumo))
  (println "> 500 filter empty not:" (not (empty? (filter #(> (:preco-total %) 500) resumo))))
  (println "> 500 some:" (some #(> (:preco-total %) 500) resumo)))



