(ns modu.cursor
  (:require [com.stuartsierra.component :as component]))

(defrecord RootCursor [init-val reset?]
  component/Lifecycle
  (start [component]
    (assoc component :root-cursor (atom init-val)))
  (stop [component]
    (if reset?
      component
      (if-let [next-val (:root-cursor component)]
        (assoc component :init-val @next-val)
        component)))

  ISwap
  (-swap! [component f]
    (update-in component [:root-cursor] #(swap! % f))))

(defn new-root-cursor [& {:keys [init-val reset?] :or {reset? false} :as opts}]
  (map->RootCursor opts))
