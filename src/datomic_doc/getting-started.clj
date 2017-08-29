;; gorilla-repl.fileformat = 1

;; **
;;; # Getting Started
;;; 
;;; * The example source codes from here: 
;;; 	* [Connect to a Database](http://docs.datomic.com/getting-started/connect-to-a-database.html)
;;; 	* [Transact Schema](http://docs.datomic.com/getting-started/transact-schema.html)
;;; 	* [Trasact Data](http://docs.datomic.com/getting-started/transact-data.html)
;;; 	* [Query the Data](http://docs.datomic.com/getting-started/query-the-data.html)
;;; 	* [See Historic Data](http://docs.datomic.com/getting-started/see-historic-data.html)
;;;  
;; **

;; **
;;; ## Connect to a Database
;; **

;; **
;;; * Import the client library and core.async
;; **

;; @@
(ns datomic-doc.getting-started
  (:require	[clojure.core.async :refer (<!!)]
            [datomic.client :as client]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; * Create the connection
;; **

;; @@
(def conn
  (<!! (client/connect
         {:db-name "hello"
          :account-id client/PRO_ACCOUNT
          :secret "mysecret"
          :region "none"
          :endpoint "localhost:8998"
          :service "peer-server"
          :access-key "myaccesskey"})))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/conn</span>","value":"#'datomic-doc.getting-started/conn"}
;; <=

;; **
;;; * Inspect the connection
;; **

;; @@
conn
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[datomic.client.impl.types.Connection 0x1836c585 &quot;#datomic.client.impl.types.Connection[{:t 63, :next-t 1000, :account-id \\&quot;00000000-0000-0000-0000-000000000000\\&quot;, :db-name \\&quot;hello\\&quot;, :db-id \\&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787\\&quot;, :timeout 60000}]&quot;]</span>","value":"#object[datomic.client.impl.types.Connection 0x1836c585 \"#datomic.client.impl.types.Connection[{:t 63, :next-t 1000, :account-id \\\"00000000-0000-0000-0000-000000000000\\\", :db-name \\\"hello\\\", :db-id \\\"59a3a8a5-5517-47f9-85aa-b0f47952a787\\\", :timeout 60000}]\"]"}
;; <=

;; **
;;; ## Transact a Schema
;; **

;; **
;;; * Compose the movie-schema (attribute definitions)
;; **

;; @@
(def movie-schema [{:db/ident :movie/title
                    :db/valueType :db.type/string
                    :db/cardinality :db.cardinality/one
                    :db/doc "The title of the movie"}
                   
                   {:db/ident :movie/genre
                    :db/valueType :db.type/string
                    :db/cardinality :db.cardinality/one
                    :db/doc "The genre of the movie"}
                   
                   {:db/ident :movie/release-year
                    :db/valueType :db.type/long
                    :db/cardinality :db.cardinality/one
                    :db/doc "The year the movie was released in theaters"}])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/movie-schema</span>","value":"#'datomic-doc.getting-started/movie-schema"}
;; <=

;; **
;;; * Transact the schema
;; **

;; @@
(<!! (client/transact conn {:tx-data movie-schema}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-before</span>","value":":db-before"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>63</span>","value":"63"}],"value":"[:t 63]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:next-t 1000]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 63, :next-t 1000, :history false}"}],"value":"[:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 63, :next-t 1000, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-after</span>","value":":db-after"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:t 1000]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1001</span>","value":"1001"}],"value":"[:next-t 1001]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1000, :next-t 1001, :history false}"}],"value":"[:db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1000, :next-t 1001, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tx-data</span>","value":":tx-data"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>#datom[13194139534312 50 #inst &quot;2017-08-29T05:05:46.692-00:00&quot; 13194139534312 true]</span>","value":"#datom[13194139534312 50 #inst \"2017-08-29T05:05:46.692-00:00\" 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[63 10 :movie/title 13194139534312 true]</span>","value":"#datom[63 10 :movie/title 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[63 40 23 13194139534312 true]</span>","value":"#datom[63 40 23 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[63 41 35 13194139534312 true]</span>","value":"#datom[63 41 35 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[63 62 &quot;The title of the movie&quot; 13194139534312 true]</span>","value":"#datom[63 62 \"The title of the movie\" 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[64 10 :movie/genre 13194139534312 true]</span>","value":"#datom[64 10 :movie/genre 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[64 40 23 13194139534312 true]</span>","value":"#datom[64 40 23 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[64 41 35 13194139534312 true]</span>","value":"#datom[64 41 35 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[64 62 &quot;The genre of the movie&quot; 13194139534312 true]</span>","value":"#datom[64 62 \"The genre of the movie\" 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[65 10 :movie/release-year 13194139534312 true]</span>","value":"#datom[65 10 :movie/release-year 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[65 40 22 13194139534312 true]</span>","value":"#datom[65 40 22 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[65 41 35 13194139534312 true]</span>","value":"#datom[65 41 35 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[65 62 &quot;The year the movie was released in theaters&quot; 13194139534312 true]</span>","value":"#datom[65 62 \"The year the movie was released in theaters\" 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[0 13 65 13194139534312 true]</span>","value":"#datom[0 13 65 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[0 13 64 13194139534312 true]</span>","value":"#datom[0 13 64 13194139534312 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[0 13 63 13194139534312 true]</span>","value":"#datom[0 13 63 13194139534312 true]"}],"value":"[#datom[13194139534312 50 #inst \"2017-08-29T05:05:46.692-00:00\" 13194139534312 true] #datom[63 10 :movie/title 13194139534312 true] #datom[63 40 23 13194139534312 true] #datom[63 41 35 13194139534312 true] #datom[63 62 \"The title of the movie\" 13194139534312 true] #datom[64 10 :movie/genre 13194139534312 true] #datom[64 40 23 13194139534312 true] #datom[64 41 35 13194139534312 true] #datom[64 62 \"The genre of the movie\" 13194139534312 true] #datom[65 10 :movie/release-year 13194139534312 true] #datom[65 40 22 13194139534312 true] #datom[65 41 35 13194139534312 true] #datom[65 62 \"The year the movie was released in theaters\" 13194139534312 true] #datom[0 13 65 13194139534312 true] #datom[0 13 64 13194139534312 true] #datom[0 13 63 13194139534312 true]]"}],"value":"[:tx-data [#datom[13194139534312 50 #inst \"2017-08-29T05:05:46.692-00:00\" 13194139534312 true] #datom[63 10 :movie/title 13194139534312 true] #datom[63 40 23 13194139534312 true] #datom[63 41 35 13194139534312 true] #datom[63 62 \"The title of the movie\" 13194139534312 true] #datom[64 10 :movie/genre 13194139534312 true] #datom[64 40 23 13194139534312 true] #datom[64 41 35 13194139534312 true] #datom[64 62 \"The genre of the movie\" 13194139534312 true] #datom[65 10 :movie/release-year 13194139534312 true] #datom[65 40 22 13194139534312 true] #datom[65 41 35 13194139534312 true] #datom[65 62 \"The year the movie was released in theaters\" 13194139534312 true] #datom[0 13 65 13194139534312 true] #datom[0 13 64 13194139534312 true] #datom[0 13 63 13194139534312 true]]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tempids</span>","value":":tempids"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598144</span>","value":"-9223301668109598144"},{"type":"html","content":"<span class='clj-long'>63</span>","value":"63"}],"value":"[-9223301668109598144 63]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598143</span>","value":"-9223301668109598143"},{"type":"html","content":"<span class='clj-long'>64</span>","value":"64"}],"value":"[-9223301668109598143 64]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598142</span>","value":"-9223301668109598142"},{"type":"html","content":"<span class='clj-long'>65</span>","value":"65"}],"value":"[-9223301668109598142 65]"}],"value":"{-9223301668109598144 63, -9223301668109598143 64, -9223301668109598142 65}"}],"value":"[:tempids {-9223301668109598144 63, -9223301668109598143 64, -9223301668109598142 65}]"}],"value":"{:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 63, :next-t 1000, :history false}, :db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1000, :next-t 1001, :history false}, :tx-data [#datom[13194139534312 50 #inst \"2017-08-29T05:05:46.692-00:00\" 13194139534312 true] #datom[63 10 :movie/title 13194139534312 true] #datom[63 40 23 13194139534312 true] #datom[63 41 35 13194139534312 true] #datom[63 62 \"The title of the movie\" 13194139534312 true] #datom[64 10 :movie/genre 13194139534312 true] #datom[64 40 23 13194139534312 true] #datom[64 41 35 13194139534312 true] #datom[64 62 \"The genre of the movie\" 13194139534312 true] #datom[65 10 :movie/release-year 13194139534312 true] #datom[65 40 22 13194139534312 true] #datom[65 41 35 13194139534312 true] #datom[65 62 \"The year the movie was released in theaters\" 13194139534312 true] #datom[0 13 65 13194139534312 true] #datom[0 13 64 13194139534312 true] #datom[0 13 63 13194139534312 true]], :tempids {-9223301668109598144 63, -9223301668109598143 64, -9223301668109598142 65}}"}
;; <=

;; **
;;; ## Transact Data
;; **

;; **
;;; * Compose a data
;; **

;; @@
(def first-movies [{:movie/title "The Goonies"
                    :movie/genre "action/adventure"
                    :movie/release-year 1985}
                   
                   {:movie/title "Commando"
                    :movie/genre "action/adventure"
                    :movie/release-year 1985}
                   
                   {:movie/title "Repo Man"
                    :movie/genre "punk dystopia"
                    :movie/release-year 1984}])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/first-movies</span>","value":"#'datomic-doc.getting-started/first-movies"}
;; <=

;; **
;;; * Transact the data
;; **

;; @@
(<!! (client/transact conn {:tx-data first-movies}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-before</span>","value":":db-before"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:t 1000]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1001</span>","value":"1001"}],"value":"[:next-t 1001]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1000, :next-t 1001, :history false}"}],"value":"[:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1000, :next-t 1001, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-after</span>","value":":db-after"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1001</span>","value":"1001"}],"value":"[:t 1001]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1005</span>","value":"1005"}],"value":"[:next-t 1005]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1001, :next-t 1005, :history false}"}],"value":"[:db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1001, :next-t 1005, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tx-data</span>","value":":tx-data"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>#datom[13194139534313 50 #inst &quot;2017-08-29T05:08:42.873-00:00&quot; 13194139534313 true]</span>","value":"#datom[13194139534313 50 #inst \"2017-08-29T05:08:42.873-00:00\" 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045418 63 &quot;The Goonies&quot; 13194139534313 true]</span>","value":"#datom[17592186045418 63 \"The Goonies\" 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045418 64 &quot;action/adventure&quot; 13194139534313 true]</span>","value":"#datom[17592186045418 64 \"action/adventure\" 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045418 65 1985 13194139534313 true]</span>","value":"#datom[17592186045418 65 1985 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045419 63 &quot;Commando&quot; 13194139534313 true]</span>","value":"#datom[17592186045419 63 \"Commando\" 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045419 64 &quot;action/adventure&quot; 13194139534313 true]</span>","value":"#datom[17592186045419 64 \"action/adventure\" 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045419 65 1985 13194139534313 true]</span>","value":"#datom[17592186045419 65 1985 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045420 63 &quot;Repo Man&quot; 13194139534313 true]</span>","value":"#datom[17592186045420 63 \"Repo Man\" 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045420 64 &quot;punk dystopia&quot; 13194139534313 true]</span>","value":"#datom[17592186045420 64 \"punk dystopia\" 13194139534313 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045420 65 1984 13194139534313 true]</span>","value":"#datom[17592186045420 65 1984 13194139534313 true]"}],"value":"[#datom[13194139534313 50 #inst \"2017-08-29T05:08:42.873-00:00\" 13194139534313 true] #datom[17592186045418 63 \"The Goonies\" 13194139534313 true] #datom[17592186045418 64 \"action/adventure\" 13194139534313 true] #datom[17592186045418 65 1985 13194139534313 true] #datom[17592186045419 63 \"Commando\" 13194139534313 true] #datom[17592186045419 64 \"action/adventure\" 13194139534313 true] #datom[17592186045419 65 1985 13194139534313 true] #datom[17592186045420 63 \"Repo Man\" 13194139534313 true] #datom[17592186045420 64 \"punk dystopia\" 13194139534313 true] #datom[17592186045420 65 1984 13194139534313 true]]"}],"value":"[:tx-data [#datom[13194139534313 50 #inst \"2017-08-29T05:08:42.873-00:00\" 13194139534313 true] #datom[17592186045418 63 \"The Goonies\" 13194139534313 true] #datom[17592186045418 64 \"action/adventure\" 13194139534313 true] #datom[17592186045418 65 1985 13194139534313 true] #datom[17592186045419 63 \"Commando\" 13194139534313 true] #datom[17592186045419 64 \"action/adventure\" 13194139534313 true] #datom[17592186045419 65 1985 13194139534313 true] #datom[17592186045420 63 \"Repo Man\" 13194139534313 true] #datom[17592186045420 64 \"punk dystopia\" 13194139534313 true] #datom[17592186045420 65 1984 13194139534313 true]]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tempids</span>","value":":tempids"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598138</span>","value":"-9223301668109598138"},{"type":"html","content":"<span class='clj-long'>17592186045418</span>","value":"17592186045418"}],"value":"[-9223301668109598138 17592186045418]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598137</span>","value":"-9223301668109598137"},{"type":"html","content":"<span class='clj-long'>17592186045419</span>","value":"17592186045419"}],"value":"[-9223301668109598137 17592186045419]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598136</span>","value":"-9223301668109598136"},{"type":"html","content":"<span class='clj-long'>17592186045420</span>","value":"17592186045420"}],"value":"[-9223301668109598136 17592186045420]"}],"value":"{-9223301668109598138 17592186045418, -9223301668109598137 17592186045419, -9223301668109598136 17592186045420}"}],"value":"[:tempids {-9223301668109598138 17592186045418, -9223301668109598137 17592186045419, -9223301668109598136 17592186045420}]"}],"value":"{:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1000, :next-t 1001, :history false}, :db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1001, :next-t 1005, :history false}, :tx-data [#datom[13194139534313 50 #inst \"2017-08-29T05:08:42.873-00:00\" 13194139534313 true] #datom[17592186045418 63 \"The Goonies\" 13194139534313 true] #datom[17592186045418 64 \"action/adventure\" 13194139534313 true] #datom[17592186045418 65 1985 13194139534313 true] #datom[17592186045419 63 \"Commando\" 13194139534313 true] #datom[17592186045419 64 \"action/adventure\" 13194139534313 true] #datom[17592186045419 65 1985 13194139534313 true] #datom[17592186045420 63 \"Repo Man\" 13194139534313 true] #datom[17592186045420 64 \"punk dystopia\" 13194139534313 true] #datom[17592186045420 65 1984 13194139534313 true]], :tempids {-9223301668109598138 17592186045418, -9223301668109598137 17592186045419, -9223301668109598136 17592186045420}}"}
;; <=

;; **
;;; ## Query the Data
;; **

;; **
;;; * Retrieve the current database value and store it in a var
;; **

;; @@
(def db (client/db conn))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/db</span>","value":"#'datomic-doc.getting-started/db"}
;; <=

;; **
;;; * Inspect the resulting var
;; **

;; @@
db
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1001</span>","value":"1001"}],"value":"[:t 1001]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1005</span>","value":"1005"}],"value":"[:next-t 1005]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1001, :next-t 1005}"}
;; <=

;; **
;;; * Compose a query: `all-movies-q`
;; **

;; @@
;; find me the ids of all entities which have an attribute called :movie/title

(def all-movies-q '[:find ?e
                    :where [?e :movie/title]])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/all-movies-q</span>","value":"#'datomic-doc.getting-started/all-movies-q"}
;; <=

;; **
;;; * Issue the query: `all-movies-q`
;; **

;; @@
(<!! (client/q conn {:query all-movies-q :args [db]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>17592186045418</span>","value":"17592186045418"}],"value":"[17592186045418]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>17592186045419</span>","value":"17592186045419"}],"value":"[17592186045419]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>17592186045420</span>","value":"17592186045420"}],"value":"[17592186045420]"}],"value":"[[17592186045418] [17592186045419] [17592186045420]]"}
;; <=

;; **
;;; * Compose a query: `all-titles-q`
;; **

;; @@
;; find all movie titles from any entity that has an attribute :movie/title and assign the title to a logic variable called ?movie-title

(def all-titles-q '[:find ?movie-title
                    :where [_ :movie/title ?movie-title]])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/all-titles-q</span>","value":"#'datomic-doc.getting-started/all-titles-q"}
;; <=

;; **
;;; * Issue the query: `all-titles-q`
;; **

;; @@
(<!! (client/q conn {:query all-titles-q :args [db]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Commando&quot;</span>","value":"\"Commando\""}],"value":"[\"Commando\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;The Goonies&quot;</span>","value":"\"The Goonies\""}],"value":"[\"The Goonies\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Repo Man&quot;</span>","value":"\"Repo Man\""}],"value":"[\"Repo Man\"]"}],"value":"[[\"Commando\"] [\"The Goonies\"] [\"Repo Man\"]]"}
;; <=

;; **
;;; * Compose a query: `titles-from-1985`
;; **

;; @@
;; find the title of any entity that has a :movie/title attribute and whose :movie/release-year is 1985

(def titles-from-1985 '[:find ?title
                        :where [?e :movie/title ?title]
                               [?e :movie/release-year 1985]])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/titles-from-1985</span>","value":"#'datomic-doc.getting-started/titles-from-1985"}
;; <=

;; **
;;; * Issue the query: `titles-from-1985`
;; **

;; @@
(<!! (client/q conn {:query titles-from-1985 :args [db]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Commando&quot;</span>","value":"\"Commando\""}],"value":"[\"Commando\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;The Goonies&quot;</span>","value":"\"The Goonies\""}],"value":"[\"The Goonies\"]"}],"value":"[[\"Commando\"] [\"The Goonies\"]]"}
;; <=

;; **
;;; * Compose a query: `all-data-from-1985`
;; **

;; @@
(def all-data-from-1985 '[:find ?title ?year ?genre
                          :where [?e :movie/title ?title]
                          		 [?e :movie/release-year ?year]
                          		 [?e :movie/genre ?genre]
                          		 [?e :movie/release-year 1985]])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/all-data-from-1985</span>","value":"#'datomic-doc.getting-started/all-data-from-1985"}
;; <=

;; **
;;; * Issue the query: `all-data-from-1985`
;; **

;; @@
(<!! (client/q conn {:query all-data-from-1985 :args [db]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;The Goonies&quot;</span>","value":"\"The Goonies\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"The Goonies\" 1985 \"action/adventure\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Commando&quot;</span>","value":"\"Commando\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"Commando\" 1985 \"action/adventure\"]"}],"value":"[[\"The Goonies\" 1985 \"action/adventure\"] [\"Commando\" 1985 \"action/adventure\"]]"}
;; <=

;; **
;;; ## See Historic Data
;; **

;; **
;;; * Find the entity id of Commando
;; **

;; @@
(def commando-id 
  (ffirst (<!! (client/q conn {:query '[:find ?e
                                        :where [?e :movie/title "Commando"]]
                               :args [db]}))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/commando-id</span>","value":"#'datomic-doc.getting-started/commando-id"}
;; <=

;; **
;;; * Issue a transaction telling Datomic about the new value for `:movie/genre`
;; **

;; @@
(<!! (client/transact conn {:tx-data [{:db/id commando-id :movie/genre "future-governor"}]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-before</span>","value":":db-before"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1001</span>","value":"1001"}],"value":"[:t 1001]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1005</span>","value":"1005"}],"value":"[:next-t 1005]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1001, :next-t 1005, :history false}"}],"value":"[:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1001, :next-t 1005, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-after</span>","value":":db-after"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1005</span>","value":"1005"}],"value":"[:t 1005]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1006</span>","value":"1006"}],"value":"[:next-t 1006]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1005, :next-t 1006, :history false}"}],"value":"[:db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1005, :next-t 1006, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tx-data</span>","value":":tx-data"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>#datom[13194139534317 50 #inst &quot;2017-08-29T06:03:37.195-00:00&quot; 13194139534317 true]</span>","value":"#datom[13194139534317 50 #inst \"2017-08-29T06:03:37.195-00:00\" 13194139534317 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045419 64 &quot;future-governor&quot; 13194139534317 true]</span>","value":"#datom[17592186045419 64 \"future-governor\" 13194139534317 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045419 64 &quot;action/adventure&quot; 13194139534317 false]</span>","value":"#datom[17592186045419 64 \"action/adventure\" 13194139534317 false]"}],"value":"[#datom[13194139534317 50 #inst \"2017-08-29T06:03:37.195-00:00\" 13194139534317 true] #datom[17592186045419 64 \"future-governor\" 13194139534317 true] #datom[17592186045419 64 \"action/adventure\" 13194139534317 false]]"}],"value":"[:tx-data [#datom[13194139534317 50 #inst \"2017-08-29T06:03:37.195-00:00\" 13194139534317 true] #datom[17592186045419 64 \"future-governor\" 13194139534317 true] #datom[17592186045419 64 \"action/adventure\" 13194139534317 false]]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tempids</span>","value":":tempids"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[],"value":"{}"}],"value":"[:tempids {}]"}],"value":"{:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1001, :next-t 1005, :history false}, :db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1005, :next-t 1006, :history false}, :tx-data [#datom[13194139534317 50 #inst \"2017-08-29T06:03:37.195-00:00\" 13194139534317 true] #datom[17592186045419 64 \"future-governor\" 13194139534317 true] #datom[17592186045419 64 \"action/adventure\" 13194139534317 false]], :tempids {}}"}
;; <=

;; **
;;; * Verify that commando has been updated
;; **

;; @@
(<!! (client/q conn {:query all-data-from-1985 :args [db]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;The Goonies&quot;</span>","value":"\"The Goonies\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"The Goonies\" 1985 \"action/adventure\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Commando&quot;</span>","value":"\"Commando\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"Commando\" 1985 \"action/adventure\"]"}],"value":"[[\"The Goonies\" 1985 \"action/adventure\"] [\"Commando\" 1985 \"action/adventure\"]]"}
;; <=

;; **
;;; * Get a current value of the database and issue the query again
;; **

;; @@
(def db (client/db conn))

(<!! (client/q conn {:query all-data-from-1985 :args [db]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;The Goonies&quot;</span>","value":"\"The Goonies\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"The Goonies\" 1985 \"action/adventure\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Commando&quot;</span>","value":"\"Commando\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;future-governor&quot;</span>","value":"\"future-governor\""}],"value":"[\"Commando\" 1985 \"future-governor\"]"}],"value":"[[\"The Goonies\" 1985 \"action/adventure\"] [\"Commando\" 1985 \"future-governor\"]]"}
;; <=

;; **
;;; * Inspect the current database value
;; **

;; @@
db
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1005</span>","value":"1005"}],"value":"[:t 1005]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1006</span>","value":"1006"}],"value":"[:next-t 1006]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1005, :next-t 1006}"}
;; <=

;; **
;;; * Take an old database value
;; **

;; @@
(def old-db (client/as-of db 1004))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/old-db</span>","value":"#'datomic-doc.getting-started/old-db"}
;; <=

;; **
;;; * Issue the same query against the `old-db`
;; **

;; @@
(<!! (client/q conn {:query all-data-from-1985 :args [old-db]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;The Goonies&quot;</span>","value":"\"The Goonies\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"The Goonies\" 1985 \"action/adventure\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Commando&quot;</span>","value":"\"Commando\""},{"type":"html","content":"<span class='clj-long'>1985</span>","value":"1985"},{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"Commando\" 1985 \"action/adventure\"]"}],"value":"[[\"The Goonies\" 1985 \"action/adventure\"] [\"Commando\" 1985 \"action/adventure\"]]"}
;; <=

;; **
;;; * See all the values that a given attribute has held over time: `history`
;; **

;; @@
(def hdb (client/history db))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.getting-started/hdb</span>","value":"#'datomic-doc.getting-started/hdb"}
;; <=

;; **
;;; * Pass the `hdb` in to a query
;; **

;; @@
(<!! (client/q conn {:query '[:find ?genre
                              :where [?e :movie/title "Commando"]
                              		 [?e :movie/genre ?genre]]
                     :args [hdb]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;future-governor&quot;</span>","value":"\"future-governor\""}],"value":"[\"future-governor\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;action/adventure&quot;</span>","value":"\"action/adventure\""}],"value":"[\"action/adventure\"]"}],"value":"[[\"future-governor\"] [\"action/adventure\"]]"}
;; <=

;; @@

;; @@
