# TheMateriaTarot
A Tarot Card application written in Compose and designed with Material 3.

This is a personal project application that I used to learn the modern Android stack. Users can start, save, and review saved readings. 

STACK
Jetpack Compose
Room for Local Persistence
Moshi for JSON conversions
Retrofit for HTTP requests
Flows to manage asynchronous data streams from the data layer
LiveData to manage asychronous data streams for the UI layer
Manual Dependency Injection
Google Cloud Endpoints for a custom external Rest API.
Junit / Espresso / MockK for testing.

ARCHITECTURE
I tried to stick with MVVM / Clean Architecture as best I could, but there are areas where the seperation of concerns is not the cleanest.

I go into further detail about my design decisions and my learning journey in this blog.

Cheers!
