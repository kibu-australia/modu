# om

A module for [om](https://github.com/swannodette/om)

## Usage

```clojure
(ns foo.core
  (:require [modu.om :refer [new-om]]
            [om.core :as om]
            [om.dom :as dom]
            [com.stuartsierra.component :as component]))

(component/system-map
  :om (new-om :component (fn [data owner] (reify om/IRender (render [_] (dom/div nil "Foo"))))
              :cursor {:foo :bar}
              :options {:target (. js/document (getElementById "foo"))}))
```
