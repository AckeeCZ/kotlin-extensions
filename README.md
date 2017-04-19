# Android Kotlin Extensions

## Purpose of library
This library serves as collection of various kotlin extensions that simplifies developers life. All Kotlin projects had its own extensions and in most cases they done the same but had different syntax etc. This project tries to unify that problem with clear separation of extensions based on its dependencies.

All extensions are collected from projects that are bases on Kotlin/Anko

## Structure
Extensions are grouped to submodules that has the same dependency. So for example if extensions has dependency to RxJava they are in separate module.

All modules has the same version. Current version is in `gradle.properties` file.
### Android Extensions
Extensions to core Android Framework and some Support Library classes like Fragment.

### Gradle
```
compile "cz.ackee.extensions:android:x.x.x"
```

### Anko Extensions
Extensions to Anko DSL library. Basically this adds only easier support to DSL with components that are not included in Anko.

### Gradle
```
compile "cz.ackee.extensions:anko:x.x.x"
```

### Picasso Extensions
Extensions dependent on Picasso. Contains async loading of URL to ImageView

### Gradle
```
compile "cz.ackee.extensions:picasso:x.x.x"
```

### Recyclerview Extensions
Extensions to Recylerview with support for click/longclick listeners

### Gradle
```
compile "cz.ackee.extensions:recyclerview:x.x.x"
```

### RX Extensions
Extensions to RxJava2 with easier subscribing/observing on particular threads and safe disposing of observables.

### Gradle
```
compile "cz.ackee.extensions:rxjava2:x.x.x"
```

