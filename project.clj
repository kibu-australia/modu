(defproject kibu/modu "0.1.0-SNAPSHOT"
  :description "Clojurescript modules for Component"
  :url "http://github.com/kibu-australia/modu"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :plugins [[lein-sub "0.2.4"]]

  :sub ["modules/reagent"
        "modules/om"
        "modules/datascript"
        "modules/sente"
        "modules/pushy"
        "modules/figwheel"]

  :aliases {"deploy-all" ["sub" "deploy" "clojars"]
            "install-all" ["sub" "install"]}

  :profiles {:dependencies [[org.clojure/clojure "1.6.0"]
                            [org.clojure/tools.namespace "0.2.4"]]})
