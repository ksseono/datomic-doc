(defproject datomic-doc "0.1.0-SNAPSHOT"
  :description "Test the source codes in Datomic documentation on Gorilla REPL"
  :url "http://docs.datomic.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :creds :gpg}}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.datomic/datomic-pro "0.9.5561.56"]
                 [com.datomic/clj-client "0.8.606"]]

  :plugins [[lein-gorilla "0.4.0"]])
