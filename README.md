# modu

Modu, like [modular](https://github.com/juxt/modular) or [system](https://github.com/danielsz/system) for Clojure, provides a set of readymade components for Clojurescript.

Modu uses our cljx fork of Stuart Sierra's [component](https://github.com/stuartsierra/component) found [here](https://github.com/kibu-australia/component)

Modules include:

* [datascript](https://github.com/kibu-australia/modu/tree/master/modules/datascript)
* [om](https://github.com/kibu-australia/modu/tree/master/modules/om)
* [pushy](https://github.com/kibu-australia/modu/tree/master/modules/pushy)
* [reagent](https://github.com/kibu-australia/modu/tree/master/modules/reagent)
* [sente](https://github.com/kibu-australia/modu/tree/master/modules/sente)
* [figwheel](https://github.com/kibu-australia/modu/tree/master/modules/figwheel)
* [weasel](https://github.com/kibu-australia/modu/tree/master/modules/weasel)
* [cursor](https://github.com/kibu-australia/modu/tree/master/modules/cursor)

## Usage

Refer to the `README.md` file inside each module for individual usage.


To use component on the client side, we need to use `set!` instead of `alter-var-root!`

```clojure
(ns foo.core
  (:require [com.stuartsierra.component :as component]
            [modu.sente :refer [new-sente-client]]))

(def ^:dynamic system
  (component/system-map
    {:sente (new-sente-client :path "/chsk" :options {:type :auto})}))

(set! system (component/start system))
```

## Contributing

Pull requests welcome for any Clojurescript library we don't currently have!

## License

Copyright © 2014

Distributed under the Eclipse Public License either version 1.0
