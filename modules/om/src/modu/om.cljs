(ns modu.om
  (:require [com.stuartsierra.component :as component]
            [om.core :as om]))

(defrecord OmRoot [component cursor options]
  component/Lifecycle
  (start [component]
    (assoc component :om (om/root component cursor options)))
  (stop [component]
    (when-let [target (:target options)]
      (om/detach-root target))
    (assoc component :om nil)))

(defn new-om-root [& {:keys [component cursor options] :as opts}]
  (map->OmRoot opts))

(defrecord OmComponent [component data owner]
  component/Lifecycle
  (start [component]
    (assoc component :component (fn [] (component data owner))))
  (stop [component]
    (assoc component :component nil)))

(defn new-om-component [& {:keys [component data owner] :as opts}]
  (map->OmComponent opts))
