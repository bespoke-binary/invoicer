(ns app.core
  (:require [cljs.nodejs :as nodejs])
  (:import (goog.labs.format csv)))

(nodejs/enable-util-print!)

(defn parse-csv [s]
  (js->clj (goog.labs.format.csv.parse s)))

(defn main [& args]
  (println "Abracadabra!"))

(set! *main-cli-fn* main)
