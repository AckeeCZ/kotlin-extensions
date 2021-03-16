[ ![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.ackeecz/extensions-android/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.ackeecz/extensions-android)

# Android Kotlin Extensions

## Purpose of library
This library serves as a collection of various Kotlin extensions that simplifies developers life. All of our Kotlin projects had its own extensions and in most cases they've done the same but had different names, syntax etc. This project tries to unify that problem with clear separation of extensions based on its dependencies.

All extensions are collected from projects that are based on Kotlin/Anko

## Structure
Extensions are grouped to submodules that have the same dependency. So for example if extensions have dependency to RxJava they are in separate module.

All modules has the same version. Current version is in `gradle.properties` file and can be seen in the badge above. 

### Android Extensions
Extensions to core Android Framework and some Support Library classes like Fragment.

```
compile "io.github.ackeecz:extensions-android:x.x.x"
```

### Anko Extensions
Extensions to Anko DSL library. Basically this adds only easier support to DSL with components that are not included in Anko.

```
compile "io.github.ackeecz:extensions-anko:x.x.x"
```

### Picasso Extensions
Extensions dependent on Picasso. Contains async loading of URL to ImageView

```
compile "io.github.ackeecz:extensions-picasso:x.x.x"
```

### Recyclerview Extensions
Extensions to Recylerview with support for click/longclick listeners

```
compile "io.github.ackeecz:extensions-recyclerview:x.x.x"
```

### RX Extensions
Extensions to RxJava2 with easier subscribing/observing on particular threads and safe disposing of observables.

```
compile "io.github.ackeecz:extensions-rxjava2:x.x.x"
```

### ViewModel Extensions
Extensions to ViewModel stuff from Google's Architecture Components 

```
compile "io.github.ackeecz:extensions-viewmodel:x.x.x"
```

### Epoxy Extensions
Extensions to Epoxy and base epoxy model.
@Deprecated due to its dependency on Anko. Use epoxy2 on projects without Anko.

```
compile "io.github.ackeecz:extensions-epoxy:x.x.x"
```

### Epoxy 2 Extensions
Epoxy extensions without dependency on Anko.

```
compile "io.github.ackeecz:extensions-epoxy2:x.x.x"
```

## License
Copyright 2018 Ackee, s.r.o.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

