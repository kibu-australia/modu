(ns modu.sente
  (:require [com.stuartsierra.component :as component]
            [weasel.repl :as repl]))

(defrecord Weasel [url]
  component/Lifecycle
  (start [component]
    (assoc component :weasel (repl/connect url)))
  (stop [component]
    component))

(defn new-weasel [& {:keys [url] :as opts}]
  (map->weasel opts))
