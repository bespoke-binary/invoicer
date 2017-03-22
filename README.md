[NodeJS](https://github.com/nodejs/node) application via [ClojureScript](https://github.com/clojure/clojurescript) using [Boot](https://github.com/boot-clj/boot) quickstarter kit.

## Usage

Download [Boot](http://boot-clj.com/) and get started:

``` shell
boot dev
```

## Starting a REPL

``` clojure
(require 'cljs.repl.node)
(cemerick.piggieback/cljs-repl (cljs.repl.node/repl-env))
```

## License

ISC
