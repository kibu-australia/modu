# figwheel

A module for [figwheel](https://github.com/bhauman/lein-figwheel)

## Usage

It is possible to use Figwheel to restart our system when code changes

;;;clojure
(ns foo.core
  (:require [com.stuartsierra.component :as component]
            [modu.figwheel :refer [new-figwheel]]))

(declare restart-system)

(def ^:dynamic systen
  (component/system-map :figwheel (new-figwheel :url "ws://127.0.0.1:9001"
                                                :on-jsload restart-system)))

(defn restart-system []
  (set! system (component/stop-system system))
  (set! system (component/start-system system)))
;;;
