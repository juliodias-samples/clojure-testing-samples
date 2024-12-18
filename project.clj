(defproject testing-samples "0.1.0-SNAPSHOT"
  :description "Exercising Clojure testing"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :plugins [[jonase/eastwood "1.4.3"]]

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [nubank/matcher-combinators "3.9.1"]
                 [prismatic/schema "1.4.1"]]

  :main ^:skip-aot testing-samples.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
