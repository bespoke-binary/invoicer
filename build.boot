(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojurescript "1.9.494"]
                 [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                 [testdouble/clojurescript.csv "0.2.0" :scope "test"]

                 [com.cemerick/piggieback "0.2.1"  :scope "test"]])

(swap! boot.repl/*default-middleware*
       conj 'cemerick.piggieback/wrap-cljs-repl)

(require
 '[adzerk.boot-cljs :refer [cljs]])

(task-options!
 pom {:project 'bespoke-binary/invoicer
      :version "0.1.0-SNAPSHOT"
      :description "Produce pretty invoices from CSV files"}
 cljs {:compiler-options {:target :nodejs}})

(deftask dev
  "Watch/compile files in development"
  []
  (comp
   (watch)
   (notify :visual true)
   (cljs :source-map true
         :optimizations :none)
   (target)))

(deftask prod
  "Compile for production"
  []
  (comp
   (cljs :optimizations :advanced)
   (target)))
