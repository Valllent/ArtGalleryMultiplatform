# Art Gallery Multiplatform

Multiplatform open-source art gallery project for exploring and searching pieces of art. It is based
on the [Art Institute of Chicago API](https://api.artic.edu/docs/). This application is designed to
provide you with a good experience in looking for information and inspiration across various
platforms (Android, Linux, Windows, MacOS).

## Application

![](utils/docs/demo.gif)

## Running

For desktop platforms, it will automatically detect your operating system and run the app.

```bash
./gradlew run
```

For Android, it will build APK into ./androidApp/build/outputs/apk/debug/.

```bash
./gradlew :androidApp:assembleDebug
```

## Technologies used

The project uses a dual shared module (for logic and for UI). This provides an opportunity to easily
migrate existing code to future platforms that do not currently support Compose Multiplatform (iOS,
Web).

- Kotlin Multiplatform
- Koin
- Ktor
- Kamel
- PreCompose Navigation
- Jetpack Compose Multiplatform
- Clean Architecture + MVVM
- Multi module Gradle project
- Coroutines / Flow
- Napier
- Material Theme