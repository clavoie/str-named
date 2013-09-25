(ns str-named.core)

(defprotocol Named
  "Protocol for helper functions associated with str-named"
  (name-or-self [value] 
                "If value implements clojure.lang.Named returns (name value), 
                 otherwise returns value"))

(extend-protocol Named
  clojure.lang.Named
  (name-or-self [named] (name named))
  java.lang.Object
  (name-or-self [object] object)
  nil
  (name-or-self [_] nil))

(defn str-named
  "Like clojure.core/str, however if a value implements clojure.lang.Named
   uses (name value) instead of (str value). Useful if stringifying values that
   may contain keywords, and the name of the keyword is desired instead of
   the full keyword value. The value :hey becomes \"hey\" instead of \":hey\", etc"
  [& values]
  (apply str (map name-or-self values)))