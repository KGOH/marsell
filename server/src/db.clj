(ns db
  (:require [clojure.java.jdbc :as jdbc]))

(def db {:dbtype "postgresql"
            :dbname "marsell"
            :host   "localhost"})

(def user
  [[:id :serial "PRIMARY KEY"]
   [:name "VARCHAR(32)"]])

(comment
  (jdbc/db-do-commands db
                       (jdbc/create-table-ddl :person user))

  (jdbc/insert! db :person {:name "Фу Бар Базович"})

  (jdbc/query db ["SELECT * FROM person"])
  (jdbc/query db ["DELETE FROM person"])

  (jdbc/db-do-commands db
                       (jdbc/drop-table-ddl :person user)))
