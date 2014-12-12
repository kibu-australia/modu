(ns modu.sente
  (:require [com.stuartsierra.component :as component]
            [taoensso.sente :as sente]))

(defrecord SenteClient [path options]
  component/Lifecycle
  (start [component]
    (let [{:keys [chsk ch-recv send-fn state]}
          (sente/make-channel-socket! path options)]
      (assoc component
        :chsk chsk
        :ch-chsk ch-recv
        :chsk-send! send-fn
        :chsk-state state)))
  (stop [component]
    (when-let [chsk (:chsk component)]
      (.stop chsk))
    (dissoc component :chsk :ch-chsk :chsk-send! :chsk-state)))

(defn new-sente-client [& {:keys [path options] :as opts}]
  (map->SenteClient opts))
