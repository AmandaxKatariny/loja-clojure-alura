(ns loja.aula3
  (:require [loja.db :as l.db]))

(println (l.db/todos-os-pedidos))

(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

(println (group-by
           minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

(println (count (vals (group-by :usuario (l.db/todos-os-pedidos)))))
(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

(println "\nPEDIDOS")

(defn total-do-item
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  "mapeia e calcula o total dos pedido"
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  "somatorio de pedidos agrupado por usário"
  [[usuario pedidos]]
  { :usuario-id usuario
    :total-de-pedidos (count pedidos)
    :preco-total (total-dos-pedidos pedidos)})

 (->> (l.db/todos-os-pedidos)
      (group-by :usuario)
      (map quantia-de-pedidos-e-gasto-total-por-usuario)
      println)

