(ns modu.datascript
  (:require [com.stuartsierra.component :as component]
            [datascript :as d]))

;; TODO: optional datoms arg and use init-db
(defrecord Datascript [schema]
  component/Lifecycle
  (start [component]
    (assoc component :conn (d/create-conn schema)))
  (stop [component]
    (assoc component :conn nil)))

(defn new-datascript [& {:keys [schema] :as opts}]
  (map->DataScript opts))
