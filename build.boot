(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojurescript "1.9.494"]
                 [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                 [testdouble/clojurescript.csv "0.2.0" :scope "test"]

                 [adzerk/boot-cljs-repl   "0.3.3"  :scope "test"]
                 [com.cemerick/piggieback "0.2.1"  :scope "test"]
                 [weasel                  "0.7.0"  :scope "test"]
                 [org.clojure/tools.nrepl "0.2.12" :scope "test"]])

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])

(deftask dev
  "Watch/compile files in development"
  []
  (comp
   (watch)
   (cljs-repl)
   (cljs :source-map true
         :optimizations :none
         :compiler-options {:target :nodejs})
   (target)))

(deftask prod
  "Compile for production"
  []
  (comp
   (cljs :optimizations :advanced
         :compiler-options {:target :nodejs})
   (target)))
