;; gorilla-repl.fileformat = 1

;; **
;;; # Tutorial
;;; 
;;; 
;; **

;; **
;;; ## Assertion
;; **

;; **
;;; * Connect to a database
;; **

;; @@
(ns datomic-doc.tutorial
  (:require	[clojure.core.async :refer (<!!)]
            [datomic.client :as client]))

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
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.tutorial/conn</span>","value":"#'datomic-doc.tutorial/conn"}
;; <=

;; **
;;; * Add colors to the inventory database
;; **

;; @@
(<!! (client/transact conn
                      {:tx-data [{:db/ident :red}
                                 {:db/ident :green}
                                 {:db/ident :blue}
                                 {:db/ident :yellow}]}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-before</span>","value":":db-before"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1005</span>","value":"1005"}],"value":"[:t 1005]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1006</span>","value":"1006"}],"value":"[:next-t 1006]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1005, :next-t 1006, :history false}"}],"value":"[:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1005, :next-t 1006, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-after</span>","value":":db-after"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1006</span>","value":"1006"}],"value":"[:t 1006]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1011</span>","value":"1011"}],"value":"[:next-t 1011]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1006, :next-t 1011, :history false}"}],"value":"[:db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1006, :next-t 1011, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tx-data</span>","value":":tx-data"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>#datom[13194139534318 50 #inst &quot;2017-08-29T07:56:07.798-00:00&quot; 13194139534318 true]</span>","value":"#datom[13194139534318 50 #inst \"2017-08-29T07:56:07.798-00:00\" 13194139534318 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045423 10 :red 13194139534318 true]</span>","value":"#datom[17592186045423 10 :red 13194139534318 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045424 10 :green 13194139534318 true]</span>","value":"#datom[17592186045424 10 :green 13194139534318 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045425 10 :blue 13194139534318 true]</span>","value":"#datom[17592186045425 10 :blue 13194139534318 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045426 10 :yellow 13194139534318 true]</span>","value":"#datom[17592186045426 10 :yellow 13194139534318 true]"}],"value":"[#datom[13194139534318 50 #inst \"2017-08-29T07:56:07.798-00:00\" 13194139534318 true] #datom[17592186045423 10 :red 13194139534318 true] #datom[17592186045424 10 :green 13194139534318 true] #datom[17592186045425 10 :blue 13194139534318 true] #datom[17592186045426 10 :yellow 13194139534318 true]]"}],"value":"[:tx-data [#datom[13194139534318 50 #inst \"2017-08-29T07:56:07.798-00:00\" 13194139534318 true] #datom[17592186045423 10 :red 13194139534318 true] #datom[17592186045424 10 :green 13194139534318 true] #datom[17592186045425 10 :blue 13194139534318 true] #datom[17592186045426 10 :yellow 13194139534318 true]]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tempids</span>","value":":tempids"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598135</span>","value":"-9223301668109598135"},{"type":"html","content":"<span class='clj-long'>17592186045423</span>","value":"17592186045423"}],"value":"[-9223301668109598135 17592186045423]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598134</span>","value":"-9223301668109598134"},{"type":"html","content":"<span class='clj-long'>17592186045424</span>","value":"17592186045424"}],"value":"[-9223301668109598134 17592186045424]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598133</span>","value":"-9223301668109598133"},{"type":"html","content":"<span class='clj-long'>17592186045425</span>","value":"17592186045425"}],"value":"[-9223301668109598133 17592186045425]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598132</span>","value":"-9223301668109598132"},{"type":"html","content":"<span class='clj-long'>17592186045426</span>","value":"17592186045426"}],"value":"[-9223301668109598132 17592186045426]"}],"value":"{-9223301668109598135 17592186045423, -9223301668109598134 17592186045424, -9223301668109598133 17592186045425, -9223301668109598132 17592186045426}"}],"value":"[:tempids {-9223301668109598135 17592186045423, -9223301668109598134 17592186045424, -9223301668109598133 17592186045425, -9223301668109598132 17592186045426}]"}],"value":"{:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1005, :next-t 1006, :history false}, :db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1006, :next-t 1011, :history false}, :tx-data [#datom[13194139534318 50 #inst \"2017-08-29T07:56:07.798-00:00\" 13194139534318 true] #datom[17592186045423 10 :red 13194139534318 true] #datom[17592186045424 10 :green 13194139534318 true] #datom[17592186045425 10 :blue 13194139534318 true] #datom[17592186045426 10 :yellow 13194139534318 true]], :tempids {-9223301668109598135 17592186045423, -9223301668109598134 17592186045424, -9223301668109598133 17592186045425, -9223301668109598132 17592186045426}}"}
;; <=

;; **
;;; * Write a helper function to make the transactions more concise
;; **

;; @@
(defn make-idents
  [x]
  (mapv #(hash-map :db/ident %) x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;datomic-doc.tutorial/make-idents</span>","value":"#'datomic-doc.tutorial/make-idents"}
;; <=

;; @@
(def sizes [:small :medium :large :xlarge])
(def types [:shirt :pants :dress :hat])
(def colors [:red :green :blue :yellow]) ; already added

(<!! (client/transact conn {:tx-data (make-idents sizes)}))
(<!! (client/transact conn {:tx-data (make-idents types)}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-before</span>","value":":db-before"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1011</span>","value":"1011"}],"value":"[:t 1011]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1016</span>","value":"1016"}],"value":"[:next-t 1016]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1011, :next-t 1016, :history false}"}],"value":"[:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1011, :next-t 1016, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-after</span>","value":":db-after"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1016</span>","value":"1016"}],"value":"[:t 1016]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1021</span>","value":"1021"}],"value":"[:next-t 1021]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1016, :next-t 1021, :history false}"}],"value":"[:db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1016, :next-t 1021, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tx-data</span>","value":":tx-data"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>#datom[13194139534328 50 #inst &quot;2017-08-29T08:30:06.928-00:00&quot; 13194139534328 true]</span>","value":"#datom[13194139534328 50 #inst \"2017-08-29T08:30:06.928-00:00\" 13194139534328 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045433 10 :shirt 13194139534328 true]</span>","value":"#datom[17592186045433 10 :shirt 13194139534328 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045434 10 :pants 13194139534328 true]</span>","value":"#datom[17592186045434 10 :pants 13194139534328 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045435 10 :dress 13194139534328 true]</span>","value":"#datom[17592186045435 10 :dress 13194139534328 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[17592186045436 10 :hat 13194139534328 true]</span>","value":"#datom[17592186045436 10 :hat 13194139534328 true]"}],"value":"[#datom[13194139534328 50 #inst \"2017-08-29T08:30:06.928-00:00\" 13194139534328 true] #datom[17592186045433 10 :shirt 13194139534328 true] #datom[17592186045434 10 :pants 13194139534328 true] #datom[17592186045435 10 :dress 13194139534328 true] #datom[17592186045436 10 :hat 13194139534328 true]]"}],"value":"[:tx-data [#datom[13194139534328 50 #inst \"2017-08-29T08:30:06.928-00:00\" 13194139534328 true] #datom[17592186045433 10 :shirt 13194139534328 true] #datom[17592186045434 10 :pants 13194139534328 true] #datom[17592186045435 10 :dress 13194139534328 true] #datom[17592186045436 10 :hat 13194139534328 true]]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tempids</span>","value":":tempids"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598127</span>","value":"-9223301668109598127"},{"type":"html","content":"<span class='clj-long'>17592186045433</span>","value":"17592186045433"}],"value":"[-9223301668109598127 17592186045433]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598126</span>","value":"-9223301668109598126"},{"type":"html","content":"<span class='clj-long'>17592186045434</span>","value":"17592186045434"}],"value":"[-9223301668109598126 17592186045434]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598125</span>","value":"-9223301668109598125"},{"type":"html","content":"<span class='clj-long'>17592186045435</span>","value":"17592186045435"}],"value":"[-9223301668109598125 17592186045435]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598124</span>","value":"-9223301668109598124"},{"type":"html","content":"<span class='clj-long'>17592186045436</span>","value":"17592186045436"}],"value":"[-9223301668109598124 17592186045436]"}],"value":"{-9223301668109598127 17592186045433, -9223301668109598126 17592186045434, -9223301668109598125 17592186045435, -9223301668109598124 17592186045436}"}],"value":"[:tempids {-9223301668109598127 17592186045433, -9223301668109598126 17592186045434, -9223301668109598125 17592186045435, -9223301668109598124 17592186045436}]"}],"value":"{:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1011, :next-t 1016, :history false}, :db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1016, :next-t 1021, :history false}, :tx-data [#datom[13194139534328 50 #inst \"2017-08-29T08:30:06.928-00:00\" 13194139534328 true] #datom[17592186045433 10 :shirt 13194139534328 true] #datom[17592186045434 10 :pants 13194139534328 true] #datom[17592186045435 10 :dress 13194139534328 true] #datom[17592186045436 10 :hat 13194139534328 true]], :tempids {-9223301668109598127 17592186045433, -9223301668109598126 17592186045434, -9223301668109598125 17592186045435, -9223301668109598124 17592186045436}}"}
;; <=

;; **
;;; * Add a schema
;; **

;; @@
(def schema-1
  [{:db/ident :inv/sku
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one}
   
   {:db/ident :inv/color
    :db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   
   {:db/ident :inv/size
    :db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   
   {:db/ident :inv/type
    :db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}])

(<!! (client/transact conn {:tx-data schema-1}))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-before</span>","value":":db-before"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1016</span>","value":"1016"}],"value":"[:t 1016]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1021</span>","value":"1021"}],"value":"[:next-t 1021]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1016, :next-t 1021, :history false}"}],"value":"[:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1016, :next-t 1021, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-after</span>","value":":db-after"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:database-id</span>","value":":database-id"},{"type":"html","content":"<span class='clj-string'>&quot;59a3a8a5-5517-47f9-85aa-b0f47952a787&quot;</span>","value":"\"59a3a8a5-5517-47f9-85aa-b0f47952a787\""}],"value":"[:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-long'>1021</span>","value":"1021"}],"value":"[:t 1021]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:next-t</span>","value":":next-t"},{"type":"html","content":"<span class='clj-long'>1022</span>","value":"1022"}],"value":"[:next-t 1022]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:history</span>","value":":history"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[:history false]"}],"value":"{:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1021, :next-t 1022, :history false}"}],"value":"[:db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1021, :next-t 1022, :history false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tx-data</span>","value":":tx-data"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>#datom[13194139534333 50 #inst &quot;2017-08-29T08:34:53.747-00:00&quot; 13194139534333 true]</span>","value":"#datom[13194139534333 50 #inst \"2017-08-29T08:34:53.747-00:00\" 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[66 10 :inv/sku 13194139534333 true]</span>","value":"#datom[66 10 :inv/sku 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[66 40 23 13194139534333 true]</span>","value":"#datom[66 40 23 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[66 41 35 13194139534333 true]</span>","value":"#datom[66 41 35 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[67 10 :inv/color 13194139534333 true]</span>","value":"#datom[67 10 :inv/color 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[67 40 20 13194139534333 true]</span>","value":"#datom[67 40 20 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[67 41 35 13194139534333 true]</span>","value":"#datom[67 41 35 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[68 10 :inv/size 13194139534333 true]</span>","value":"#datom[68 10 :inv/size 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[68 40 20 13194139534333 true]</span>","value":"#datom[68 40 20 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[68 41 35 13194139534333 true]</span>","value":"#datom[68 41 35 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[69 10 :inv/type 13194139534333 true]</span>","value":"#datom[69 10 :inv/type 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[69 40 20 13194139534333 true]</span>","value":"#datom[69 40 20 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[69 41 35 13194139534333 true]</span>","value":"#datom[69 41 35 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[0 13 69 13194139534333 true]</span>","value":"#datom[0 13 69 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[0 13 66 13194139534333 true]</span>","value":"#datom[0 13 66 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[0 13 68 13194139534333 true]</span>","value":"#datom[0 13 68 13194139534333 true]"},{"type":"html","content":"<span class='clj-unkown'>#datom[0 13 67 13194139534333 true]</span>","value":"#datom[0 13 67 13194139534333 true]"}],"value":"[#datom[13194139534333 50 #inst \"2017-08-29T08:34:53.747-00:00\" 13194139534333 true] #datom[66 10 :inv/sku 13194139534333 true] #datom[66 40 23 13194139534333 true] #datom[66 41 35 13194139534333 true] #datom[67 10 :inv/color 13194139534333 true] #datom[67 40 20 13194139534333 true] #datom[67 41 35 13194139534333 true] #datom[68 10 :inv/size 13194139534333 true] #datom[68 40 20 13194139534333 true] #datom[68 41 35 13194139534333 true] #datom[69 10 :inv/type 13194139534333 true] #datom[69 40 20 13194139534333 true] #datom[69 41 35 13194139534333 true] #datom[0 13 69 13194139534333 true] #datom[0 13 66 13194139534333 true] #datom[0 13 68 13194139534333 true] #datom[0 13 67 13194139534333 true]]"}],"value":"[:tx-data [#datom[13194139534333 50 #inst \"2017-08-29T08:34:53.747-00:00\" 13194139534333 true] #datom[66 10 :inv/sku 13194139534333 true] #datom[66 40 23 13194139534333 true] #datom[66 41 35 13194139534333 true] #datom[67 10 :inv/color 13194139534333 true] #datom[67 40 20 13194139534333 true] #datom[67 41 35 13194139534333 true] #datom[68 10 :inv/size 13194139534333 true] #datom[68 40 20 13194139534333 true] #datom[68 41 35 13194139534333 true] #datom[69 10 :inv/type 13194139534333 true] #datom[69 40 20 13194139534333 true] #datom[69 41 35 13194139534333 true] #datom[0 13 69 13194139534333 true] #datom[0 13 66 13194139534333 true] #datom[0 13 68 13194139534333 true] #datom[0 13 67 13194139534333 true]]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tempids</span>","value":":tempids"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598123</span>","value":"-9223301668109598123"},{"type":"html","content":"<span class='clj-long'>66</span>","value":"66"}],"value":"[-9223301668109598123 66]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598122</span>","value":"-9223301668109598122"},{"type":"html","content":"<span class='clj-long'>67</span>","value":"67"}],"value":"[-9223301668109598122 67]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598121</span>","value":"-9223301668109598121"},{"type":"html","content":"<span class='clj-long'>68</span>","value":"68"}],"value":"[-9223301668109598121 68]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-9223301668109598120</span>","value":"-9223301668109598120"},{"type":"html","content":"<span class='clj-long'>69</span>","value":"69"}],"value":"[-9223301668109598120 69]"}],"value":"{-9223301668109598123 66, -9223301668109598122 67, -9223301668109598121 68, -9223301668109598120 69}"}],"value":"[:tempids {-9223301668109598123 66, -9223301668109598122 67, -9223301668109598121 68, -9223301668109598120 69}]"}],"value":"{:db-before {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1016, :next-t 1021, :history false}, :db-after {:database-id \"59a3a8a5-5517-47f9-85aa-b0f47952a787\", :t 1021, :next-t 1022, :history false}, :tx-data [#datom[13194139534333 50 #inst \"2017-08-29T08:34:53.747-00:00\" 13194139534333 true] #datom[66 10 :inv/sku 13194139534333 true] #datom[66 40 23 13194139534333 true] #datom[66 41 35 13194139534333 true] #datom[67 10 :inv/color 13194139534333 true] #datom[67 40 20 13194139534333 true] #datom[67 41 35 13194139534333 true] #datom[68 10 :inv/size 13194139534333 true] #datom[68 40 20 13194139534333 true] #datom[68 41 35 13194139534333 true] #datom[69 10 :inv/type 13194139534333 true] #datom[69 40 20 13194139534333 true] #datom[69 41 35 13194139534333 true] #datom[0 13 69 13194139534333 true] #datom[0 13 66 13194139534333 true] #datom[0 13 68 13194139534333 true] #datom[0 13 67 13194139534333 true]], :tempids {-9223301668109598123 66, -9223301668109598122 67, -9223301668109598121 68, -9223301668109598120 69}}"}
;; <=

;; @@

;; @@
