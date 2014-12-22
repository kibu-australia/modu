(ns modu.cursor
  (:require [com.stuartsierra.component :as component]))

(defrecord Cursor [init-val]
  component/Lifecycle
  (start [component]
    (assoc component :cursor (atom init-val)))
  (stop [component]
    component)

  ISwap
  (-swap! [component f]
    (update-in component [:cursor] #(swap! % f))))

(defn new-cursor [& {:keys [init-val] :as opts}]
  (map->Cursor opts))
