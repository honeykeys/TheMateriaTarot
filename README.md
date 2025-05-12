# The Materia Tarot

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
A beautifully designed, native Android Tarot Card application built with Jetpack Compose and Material 3, offering users the ability to perform, save, and review Tarot readings. This project served as a deep dive into the modern Android development stack.

---

## Table of Contents

* [Project Overview](#project-overview)
* [Key Features](#key-features)
* [Screenshots & Demo](#screenshots--demo)
* [Technology Stack](#technology-stack)
* [Architecture](#architecture)
* [Development Journey & Key Learnings](#development-journey--key-learnings)
* [Setup & Build Instructions](#setup--build-instructions)
* [Testing](#testing)
* [Future Improvements](#future-improvements)
* [Contributing](#contributing)
* [License](#license)
* [Author](#author)

---

## Project Overview

The Materia Tarot is a personal Android application developed to explore and master the modern Android development stack. It provides users with a digital Tarot experience, allowing them to draw cards, conduct readings, save their sessions for later reflection, and review past readings. The application emphasizes a clean user interface using Material 3 components and robust local data persistence.

---

## Key Features

* **Tarot Readings:** Perform digital Tarot readings (e.g., single card, three-card spread, Celtic Cross - *specify what's implemented*).
* **Card Library/Viewer:** Browse and view details for each Tarot card. *(The "Library" using LazyColumn you mentioned).*
* **Interactive Readings:** Navigate through drawn cards using a HorizontalPager.
* **Card Information Display:** View detailed information about a selected card using a ModalBottomDrawer.
* **Save & Review Readings:** Persist readings locally on the device using Room database.
* **Intuitive UI:** Designed with Material 3 components for a modern Android look and feel.

---
## Technology Stack

This application is built entirely with modern Android technologies:

* **UI Toolkit:** **Jetpack Compose** - For building the native UI declaratively with Kotlin.
    * Utilized base Material 3 composables, with customizations where necessary.
    * Key Composables employed: `LazyColumn` (for the "Library" view), `HorizontalPager` (for navigating TarotReadings), `ModalBottomDrawer` (for displaying card information).
* **Local Data Persistence:** **Room Persistence Library**
    * Used for saving and retrieving Tarot readings locally on the device.
    * Implemented `TypeConverter` to handle storing complex data types (like lists of custom objects) as JSON strings within the Room database.
* **JSON Conversion:** **Moshi**
    * Leveraged for serializing complex Kotlin objects (e.g., lists of cards within a reading) into JSON strings for storage with Room and deserializing them back.
* **Asynchronous Programming:** **Kotlin Coroutines & Flows / LiveData**
    * Used `Flow` to stream data (e.g., IDs of saved readings) between data and domain layers.
    * Converted `Flow` to `LiveData` for observation by the UI layer, ensuring UI updates are lifecycle-aware.
* **Dependency Management:** **Manual Dependency Injection**
    * Implemented using an `AppContainer` pattern.
    * *(Acknowledged that Hilt/Dagger would be considered for future major feature additions for more robust DI.)*
* **Testing:**
    * **JUnit:** For unit testing business logic.
    * **Espresso:** For UI/integration testing.
    * **MockK:** For creating mocks and verifying interactions in tests.
    * *(Primarily relied on functional testing via emulator and device due to project size.)*
* **Language:** **Kotlin**

---

## Architecture

The application follows **MVVM (Model-View-ViewModel)** principles, striving towards a **Clean Architecture** approach to separate concerns and improve maintainability.

* **UI Layer (View):** Jetpack Compose screens and composables, observing `LiveData` from ViewModels.
* **ViewModel Layer:** Holds UI-related data in a lifecycle-conscious way, exposes data to the UI via `LiveData`, and communicates with the domain layer/use cases.
* **Domain Layer (Use Cases - Conceptual/Actual):** Encapsulates business logic. 
* **Data Layer (Repositories):** Manages data sources (Room database), providing a clean API for ViewModels to access and manipulate data.

My journey into Android architecture involved significant learning, particularly around SOLID principles. An early experience with an overly complex ViewModel underscored the importance of structured architecture, leading to the adoption of MVVM and Clean Architecture concepts, even if the implementation is an ongoing refinement.

---

## Development Journey & Key Learnings

This project was a significant learning endeavor into the modern Android stack. Key challenges and learnings included:

* **Mastering Jetpack Compose:** Transitioning to a declarative UI paradigm and effectively using various composables like `LazyColumn`, `HorizontalPager`, and `ModalBottomDrawer`.
* **Room Database Nuances:** Overcoming challenges with storing complex data types by implementing `TypeConverter` with Moshi for JSON serialization. This involved an iterative process, initially using multiple `TypeConverter`s and later refactoring for simplicity.
* **Asynchronous Data Flow:** Effectively using Kotlin Flows for data streaming from the database and converting them to `LiveData` for UI consumption.
* **Architectural Decisions:** Understanding and applying MVVM and Clean Architecture principles to create a more maintainable and scalable application, learning from initial complexities.
* **Dependency Injection:** Implementing manual DI and recognizing the benefits and potential future adoption of libraries like Hilt/Dagger.
* **Testing Practices:** Gaining experience with JUnit, Espresso, and MockK, while also understanding the practical role of manual functional testing in smaller projects.

---

## Setup & Build Instructions

To build and run this project locally:

1.  **Prerequisites:**
    * Android Studio (latest stable version recommended - e.g., Iguana, Jellyfish)
    * Kotlin Plugin installed in Android Studio
    * Android SDK configured with appropriate API levels

2.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/honeykeys/TheMateriaTarot.git](https://github.com/honeykeys/TheMateriaTarot.git)
    cd TheMateriaTarot
    ```

3.  **Open in Android Studio:**
    * Open Android Studio.
    * Select "Open an existing Android Studio project."
    * Navigate to the cloned `TheMateriaTarot` directory and open it.

4.  **Build the Project:**
    * Allow Android Studio to sync Gradle files.
    * Click on "Build" > "Make Project" (or the green hammer icon).

5.  **Run the Application:**
    * Select an emulator or connect a physical Android device.
    * Click on "Run" > "Run 'app'" (or the green play button).

*(Add any specific notes if there are API keys to configure in `local.properties` or other environment-specific setups, though for a local Tarot app, this is less likely).*

---

## Testing

The project includes a combination of:
* **Unit Tests:** Located in `app/src/test/java/`. (Uses JUnit and MockK).
* **Instrumentation (UI/Integration) Tests:** Located in `app/src/androidTest/java/`. (Uses Espresso).

To run tests:
* You can run them from within Android Studio by right-clicking on the test files or directories and selecting "Run tests."
* Or use Gradle commands in the terminal: `./gradlew test` for unit tests, `./gradlew connectedAndroidTest` for instrumentation tests (requires a connected device/emulator).

---

## Future Improvements

As noted in the original README:
* **DESIGN:** Collaborate with a UX/UI designer to further enhance the application's aesthetics and user flow.
* **FEATURES:** Incorporate new features based on feedback (e.g., from the planned 20 testers for Play Store submission). This project is intended for continued development.

*(You can also add more specific technical improvements here if you have them in mind, e.g., "Implement Hilt for dependency injection," "Expand test coverage," "Add more complex Tarot spreads.")*

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
*(If you haven't added a LICENSE file, consider doing so. MIT is a common and permissive choice.)*

---

## Author

* **[Your Name/GitHub Username (honeykeys)]**
* GitHub: [https://github.com/honeykeys](https://github.com/honeykeys)
* LinkedIn: *(Add your LinkedIn profile URL if you want)*

- 

![Screenshot from 2023-12-09 00-52-07](https://github.com/honeykeys/TheMateriaTarot/assets/73562496/a7b98b09-fb33-41b5-bd97-e6ae41a9b6b6)
![Screenshot from 2023-12-09 00-52-39](https://github.com/honeykeys/TheMateriaTarot/assets/73562496/36436aed-033b-4942-8ec4-6285bdf974dc)
![Screenshot from 2023-12-09 00-53-08](https://github.com/honeykeys/TheMateriaTarot/assets/73562496/9ca9a8f7-f00a-4e0f-af31-a443d00dddd0)


I go into further detail about my design decisions and my learning journey in this blog.

Cheers!
