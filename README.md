# deezal
next generation music streaming that combines best features of Deezer and Tidal releasing on April 1st ;)

## Overview

- Kotlin is main language used in the project
- VIPER is used as architecture
- Packaging
- Dagger2 is used as dependency manager
- Network layer is separated via an abstract layer to promote loosely coupled code
- View Extensions
- Logging
- Dependencies
- Unit testing

## Kotlin
- The app's core language is `Kotlin`, which is preferred language for Android Apps Development

## VIPER

- Every layer in VIPER has Base contract to impose app wide rules
- All the UI interaction and display logic goes in View layer which is Activity in our case
- Presenter handles validation logic
- Interactor handles business logic and network calls
- See `commons` -> `contracts` -> for Base classes that impose some common VIPER contracts in the project

## Packaging
- There are 2 main packages; `app` and `commons`
- `commons` has core or base implementations or interfaces that is used by `app`'s features
- `app` package has feature-wise packaging
- Each feature has `contracts` package that describes contracts among the layers of this feature
- Each feature has `view`, `presenter` and `interactor` packages for their implementation classes respectively
- If feature is called or started or navigated from outside, there is a `router` package which describes how feature can be accessed or how the screen of this feature should be navigated
- Each feature has api package which contains files for API Service end-point, request logic and response data class

## Dagger2

- `Dagger2` is used as dependency manager
- All the dependencies are injected using Dagger2
- Each feature has its own `dependency` module


## Network
- `Retrofit` is used for networking in this project
- Network layer is created to allow abstraction between the core business logic and network library
- Simple `onSuccess` and `onFailure` callbacks are implemented in `Interactor`, which does not know the real request or response logic
- There is a Urls file in the `common` -> `network` package to manage the app urls accordingly in one place
- We can put Urls in `BuildConfig` flavour-wise but it can also be used through this `Urls.kt` file if needed

## Extensions
- View extensions as `hide()` `show()` `enable()` and `disable()` are written (although enable/disable are not used) to help writing code with less boiler plate
- Find these in `commons` -> `extensions`

## Logging
- A simple logger named `DeezalLogger` is written as a wrapper on Log.d to configure logs at App's `onCreate()` (see `DeezalApp` in `commons` -> `application`) whethter logs should be sent or not

## Dependencies
- All dependencies are declare in `dependencies.gradle` with at least 1-line description on 3rd-party library to make `build.gradle` less cluttery and make both of these files readable.

## Unit Testing
- Unit tests are written for `Interactor` and `Presenter`
- All unit tests are written in Kotlin 
- `Mockito` is used to mock the objects that are required in the unit test by the code
- There is a `TestUtils` class which provide dummy objects required in tests (where they cant be mocked)




