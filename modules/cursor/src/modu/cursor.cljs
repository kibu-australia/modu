(ns modu.cursor
  (:require [com.stuartsierra.component :as component]))

(defrecord Cursor [init-val reset?]
  component/Lifecycle
  (start [component]
    (assoc component :cursor (atom init-val)))
  (stop [component]
    (if reset?
      component
      (assoc component :init-val @(:cursor component))))

  ISwap
  (-swap! [component f]
    (update-in component [:cursor] #(swap! % f))))

(defn new-cursor [& {:keys [init-val reset?] :or {reset? false} :as opts}]
  (map->Cursor opts))
