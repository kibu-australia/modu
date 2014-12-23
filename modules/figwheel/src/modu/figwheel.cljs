(ns modu.figwheel
  (:require [com.stuartsierra.component :as component]
            [figwheel.client :as fw]))

(defrecord Figwheel [url on-jsload]
  component/Lifecycle
  (start [component]
    (assoc component :figwheel (fw/start :url websocket-url
                                         :on-jsload on-jsload)))
  (stop [component]
    component))

(defn new-figwheel [& {:keys [url on-jsload] :as opts}]
  (map->Figwheel opts))
