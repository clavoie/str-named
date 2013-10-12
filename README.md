str-named
=========

`str-named` is a Clojure function used to stringify values, 
some of which may implement `clojure.lang.Named`, such as keywords. 
I found the need to constantly rewrite this function, or a variant of this function, with every new Clojure project.
I finally decided to move `str-named` into a library instead. 
It seems that some other [Clojure projects](https://github.com/weavejester/hiccup/blob/1f7177392b273adb966513daad87f4a4a9c9341a/src/hiccup/util.clj)
similarly define [such a function](https://github.com/noprompt/garden/blob/edf0decc7f588a666a52d6d194be0bd30f04a243/src/cljx/garden/util.cljx).

## Installation

Add the following dependency to your `project.clj` file:

```
[str-named "1.0.0"]
```

## Usage

`str-named` can be used as you would `clojure.core/str`:

```Clojure
(ns project.core
  (:require
    [str-named.core :refer [str-named]]))
    
(str-named 10 \- :keyword)
;=> "10-keyword"
```

Any arguments to `str-named` which implement `clojure.lang.Named`, such as keywords, will
have `(name value)` used to produce the string representation of the value instead of `(str value)`.
All other values will have their string representation produced by calling `(str value)` as with
`clojure.core/str`.

## License

Copyright © 2013 Chris LaVoie

Distributed under the Eclipse Public License, the same as Clojure.
