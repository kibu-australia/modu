# om

A module for [om](https://github.com/swannodette/om)

## Usage

```clojure
(ns foo.core
  (:require [modu.om :refer [new-om]]
            [modu.cursor :refer [new-root-cursor]]
            [om.core :as om]
            [om.dom :as dom]
            [com.stuartsierra.component :as component]))

(defn my-component [data owner] 
  (reify om/IRender (render [_] (dom/div nil "Foo"))))

(defn new-system []
  (component/system-map
    :om (new-om :component my-component
                :root-cursor {:foo :bar}
                :options {:target (. js/document (getElementById "foo"))})))

;; using modu.cursor
(defn new-system-with-cursor []
  (-> (component/system-map
        :root-cursor (new-root-cursor :init-val {:foo :bar})
        :om (new-om :component my-component
                    :options {:target (. js/document (getElementById "foo"))}))
      (component/system-using 
        {:om {:root-cursor :root-cursor}})))
```
