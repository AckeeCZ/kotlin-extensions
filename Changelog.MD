# Changelog

## 1.0.10
- Added proguard rules to `anko` module.

## 1.0.9
- Add `EpoxyModelWithLayout` - Epoxy Model with view contained in `ViewLayout`

## 1.0.8
- Add `ViewLayout` - class representation of layout created with anko, extensions for creating such layout.

## 1.0.7
- Deprecated `colorWithAlpha` in favor of `colorWithOpacity` to match better naming
- Add extension `Int.withOpacity` method to use opacity in percentage directly on Int color

## 1.0.4, 1.0.5, 1.0.6
- Service update when migrating from internal GitLab to GitHub

## 1.0.3
- Little code clean in RxExtensions
- Add extensions for Schedulers to Flowable type

## 1.0.2
- Add conversion from Drawable to Bitmap via Drawable.toBitmap() function
- Add conversion between Int and Boolean

## 1.0.1
- Add color and colorWithAlpha extensions for Fragment

## 1.0.0
- 🎉 Update to 1.0.0 version 💪
- Add extensions to ViewModels - shortcut for providing ViewModels in Fragments/Activities
- Breaking Changes - methods returning Drawables are now nullables to comply with the new support library

## 0.1.9
- Add extensions (one) for Epoxy

## 0.1.8
- Add Extension function operator for CompositeDisposable so you can call
```
    disposables += viewmodel.observeSomething().subscribe()
```

## 0.1.7
- Add extensions for tinting drawables and retrieving colors list
- Add CardView with its own lparams. Fixes issue with ClassCastException

## 0.1.6
- Finally attached sources

## 0.1.5
- Remove dimen() extension on context/view

## 0.1.4
- Add subscribeOn*/observeOnMainThread extensnions for Completable, Maybe and Single

## 0.1.3
- Add optinal attribute to Context.statusbarHeight for restricting size resolving to Lollipop and higher

## 0.1.2
- Add `ViewGroup.inflate` method to Android Extensions

## 0.1.1
- Add `ViewGroup.ankoContext` property to Anko extensions