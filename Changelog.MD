# Changelog

## 0.1.1
- Add `ViewGroup.ankoContext` property to Anko extensions

## 0.1.2
- Add `ViewGroup.inflate` method to Android Extensions

## 0.1.3
- Add optinal attribute to Context.statusbarHeight for restricting size resolving to Lollipop and higher

## 0.1.4
- Add subscribeOn*/observeOnMainThread extensnions for Completable, Maybe and Single

## 0.1.5
- Remove dimen() extension on context/view

## 0.1.6
- Finally attached sources

## 0.1.7
- Add extensions for tinting drawables and retrieving colors list
- Add CardView with its own lparams. Fixes issue with ClassCastException

## 0.1.8
- Add Extension function operator for CompositeDisposable so you can call
```
    disposables += viewmodel.observeSomething().subscribe()
```

## 0.1.9
- Add extensions (one) for Epoxy

## 1.0.0
- 🎉 Update to 1.0.0 version 💪
- Add extensions to ViewModels - shortcut for providing ViewModels in Fragments/Activities
- Breaking Changes - methods returning Drawables are now nullables to comply with new support library