(ns modu.reagent
  (:require [com.stuartsierra.component :as component]
            [reagent.core :as reagent]))

(defrecord Reagent [comp container]
  component/Lifecycle
  (start [component]
    (assoc component :reagent (reagent/render-component comp container)))
  (stop [component]
    (when container
      (reagent/unmount-component-at-node container))
    (assoc component :reagent nil)))

(defn new-reagent [& {:keys [comp container] :as opts}]
  (map->Reagent opts))

(defrecord ReagentComponent [component state]
  component/Lifecycle
  (start [component]
    (assoc component :component (fn [] (component state))))
  (stop [component]
    (assoc component :component nil)))

(defn new-component [& {:keys [component state] :as opts}]
  (map->ReagentComponent opts))
