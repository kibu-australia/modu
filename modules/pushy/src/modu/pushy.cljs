(ns modu.pushy
  (:require [com.stuartsierra.component :as component]
            [goog.events :as events]
            [pushy.core :as pushy])
  (:import goog.history.EventType))

(defrecord Pushy [dispatch-fn match-fn]
  component/Lifecycle
  (start [component]
    (assoc component :pushy (pushy/push-state! dispatch-fn match-fn)))
  (stop [component]
    (when-let [key (:pushy component)]
      (events/unlistenByKey key)
      (events/unlisten pushy/history EventType.NAVIGATE))
    (dissoc component :pushy)))

(defn new-pushy [& {:keys [dispatch-fn match-fn] :as opts}]
  (map->Pushy opts))
