str-named
=========

Clojure function used to stringify implementers of clojure.lang.Named using (name value) instead of (str value). Arguments to str-named can be mixed:

```Clojure
(= "10-keyword" (str-named 10 \- :keyword))
;=> true
```


## Installation

clojars at some point

## License

Copyright © 2013 Chris LaVoie

Distributed under the Eclipse Public License, the same as Clojure.
