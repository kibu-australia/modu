# reagent

A module for [reagent](https://github.com/reagent-project/reagent)

## Usage

```clojure
(ns foo.core
  (:require [modu.reagent :refer [new-reagent]]
            [com.stuartsierra.component :as component]))

(component/system-map
  :reagent (new-reagent :component (fn [] [:div "Foo"])
                        :container (.-body js/document)))
```
