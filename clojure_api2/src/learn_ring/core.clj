(ns learn_ring.core
   (:require [ring.adapter.jetty :refer [run-jetty]]
             [ring.middleware.reload :refer [wrap-reload]]))


(defn our-middleware [res content-type]
   (assoc-in res [:headers "content-type"] content-type))


(defn handler [req]
   (our-middleware{:status 200
   :body "heyy!y"} "text/plain"))

(defn -main []
(println "Server on 3k!")
    (run-jetty (wrap-reload #'handler) {:port 3000}))