(ns modu.sente
  (:require [com.stuartsierra.component :as component]
            [figwheel.client :as fw]))

(defrecord Figwheel [websocket-url on-jsload]
  component/Lifecycle
  (start [component]
    (assoc component :figwheel (fw/start :websocket-url websocket-url
                                         :on-jsload on-jsload)))
  (stop [component]
    component))

(defn new-figwheel [& {:keys [websocket-url on-jsload] :as opts}]
  (map->Figwheel opts))
