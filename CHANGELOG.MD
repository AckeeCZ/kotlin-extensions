# Changelog

## [3.1.0] - 2023-06-14
### Changed
- Upgrade dependencies (for AndroidX)
- Remove Jetifier


## **2.0.3**
- Update Epoxy dependency to 4.6.3

## **2.0.2**
- Add support for `unbind` in `EpoxyModelWithViewBinding`

## **2.0.1**
- Fix proguard rules in `anko` module which were not changed after package name changes in `2.0.0`

## **2.0.0**
- ‼ Breaking changes ahead ‼
- Change package name of a libraries. It follows the groupId defined in 1.5.0. New package name is `io.github.ackeecz.extensions.$libraryName`
- Removed deprecated code
- Removed recyclerview and viewmodel libraries because there are far better alternatives through androidx libraries.
- Added more docs

## **1.5.0**
- Migration from jCenter to Maven Central 🎉
- ‼️ Important ‼️ groupId and artifactId has changed. New groupId is `io.github.ackeecz` and artifact ids now have a prefix `extensions`. See README.MD

## 1.4.1
- Tweak luminance threshold in the ripple color formula for `backgroundDrawable`

## 1.4.0
- Add `epoxy2` module that does not have a dependency on Anko. This module now contains EpoxyModelWithViewBinding.

## 1.3.2
- Add `openPlayStore` extension on `Context` and `Fragment`

## 1.3.1
- Deprecate `Drawable.toBitmap`, `View.visible` and `View.asBitmap` in favor of the Core KTX extensions
- Add check for dark mode with `Context.isDarkModeOn` and `View.isDarkModeOn`
- Adjust `backgroundDrawable` to calculate default ripple color based on luminance of the normal color

## 1.3.0
- Add `focused` state to `backgroundDrawable` extension
- Move `Drawable.toBitmap` function to `DrawableExtensions`
- Create `onThrottledClick` extension which prevents the view to be clicked on again for a small time interval

## 1.2.0
- Rename extensions `drawableLeft` (Right, Top, Bottom) to `drawableLeftResource` and corresponding variants
- Add extensions `drawableLeft` (Right, Top, Bottom) which are using Drawable as input parameter 

## 1.1.1
- Use darker color for pressed state in buttonDrawable function

## 1.1.0
- AndroidX support

## 1.0.10
- Added proguard rules to `anko` module.
- Deprecated `CompositeDisposable.plus` in favor of RxKotlin library extension
- Added Drawable extensions

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
