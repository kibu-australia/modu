# sente

A module for [sente](https://github.com/ptaoussanis/sente)

## Usage

```clojure
(ns foo.core
  (:require [modu.sente :refer [new-sente-client]]
            [com.stuartsierra.component :as component]))

(component/system-map
  :sente (new-sente-client :path "/chsk" :options {:type :auto}))
```
