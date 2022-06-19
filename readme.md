<h1 align="center">PhotoHub </h1>

PhotoHub is a wallpaper app built purely with Kotlin and Android Architecture Components using the [Unsplash API](https://unsplash.com/documentation#list-photos).

## Download
Download the latest apk from the [apk folder](https://github.com/SoumikBhatt/PhotoHub/tree/development/apk)

## ✨ Features

- Infinite list of wallpaper
- Download Full size wallpaper in your device
- Share wallpaper with others

## Tech stack & Open-source libraries
- Minimum SDK level 23
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- Jetpack
  - Lifecycle - Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel - Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - LiveData - Build data objects that notify views when the underlying dataset changes
  - ViewBinding - Interacting with the Views.
  - Paging3 - For loading infinite list (Pagination).
  - Navigation - Handles everything needed for in-app navigation.
- Architecture
  - MVVM Architecture (View - LiveData - ViewModel - Model)
  - Repository Pattern
- [Retrofit2](https://github.com/square/retrofit) - Construct the REST APIs.
- [Glide](https://github.com/bumptech/glide) - Loading images from network.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components for building the UI.
- Custom Views
  - [Shimmer](https://github.com/facebook/shimmer-android) - For loading views.
  - [PhotoView](https://github.com/Baseflow/PhotoView) - For Zoom In and Zoom Out features in Full screen Image


## Screenshots

Gallery (Portrait)    |  Gallery (Landscape)    
:-------------------------:|:-------------------------:|
![](https://github.com/SoumikBhatt/PhotoHub/blob/development/screenshots/gallery.png)|![](https://github.com/SoumikBhatt/PhotoHub/blob/development/screenshots/gallery_landscape.png)

<br>
<br/>

Fullscreen (Portrait)    |  Fullscreen (Landscape)    
:-------------------------:|:-------------------------:|
![](https://github.com/SoumikBhatt/PhotoHub/blob/development/screenshots/full_screen.png)|![](https://github.com/SoumikBhatt/PhotoHub/blob/development/screenshots/full_screen_landscape.png)

