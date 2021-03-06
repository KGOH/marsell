(ns app.home.model
  (:require [re-frame.core :as rf]))

(def index-page ::index)

(rf/reg-event-fx
 index-page
 (fn [{db :db} [_ hook params]]
   (prn "home "hook)
   {:db db}))
