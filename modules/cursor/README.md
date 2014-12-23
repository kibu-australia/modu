# cursor

A module useful for handling global state

## Usage

Refer to [modu.om](https://github.com/kibu-australia/modu/tree/master/modules/om) for example usage

It is also possible to reset RootCursor's state to the initial value each time the `start` method is called:

```clojure
(new-root-cursor :init-val {:foo :bar} :reset? true)
```
