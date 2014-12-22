(ns modu.om
  (:require [com.stuartsierra.component :as component]
            [om.core :as om]))

(defrecord Om [component root-cursor options]
  component/Lifecycle
  (start [component]
    (assoc component :om (om/root component root-cursor options)))
  (stop [component]
    (when-let [target (:target options)]
      (om/detach-root target))
    (dissoc component :om)))

(defn new-om [& {:keys [component root-cursor options] :as opts}]
  (map->Om opts))
