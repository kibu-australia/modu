(ns modu.reagent
  (:require [com.stuartsierra.component :as component]
            [reagent.core :as reagent]))

(defrecord Reagent [component container]
  component/Lifecycle
  (start [component]
    (assoc component :reagent (reagent/render-component (:component component)
                                                        container)))
  (stop [component]
    (when container
      (reagent/unmount-component-at-node container))
    (dissoc component :reagent)))

(defn new-reagent [& {:keys [component container] :as opts}]
  (map->Reagent opts))
