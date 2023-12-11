# TheMateriaTarot
A Tarot Card application written in Compose and designed with Material 3.

This is a personal project application that I used to learn the modern Android stack. Users can start, save, and review saved readings. 

STACK

**Jetpack Compose**
- I stuck with base Material 3 composables for the most part, customizing where I felt necessary. The three most interesting Composables I used were a LazyColumn to create my "Library", a HorizontalPager to create TarotReadings, and a ModalBottomDrawer to display information about the Card being displayed.

**Room for Local Persistence**
- In order to "save" readings, I needed to implement some kind of persistent storage. Room's basic setup was simple enough (setting up the Database, the Data Access Object, the Entity) but I encountered an issue storing a list of complex objects, which required me to use a TypeConverter to convert the List into a JSON string.
  
**Moshi for JSON conversions**
- I used Moshi to convert my complex objects into JSON strings. At one point, I was using a List<TarotCard> and a Map<Integer, Boolean> to track certain behaviors, which required me to use two TypeConverters. I was able to refactor my application to not use the Map in the end.
  
**Retrofit for HTTP requests**
- I wanted to include some kind of remote call in the application but I did not want to depend on a free API nor pay for one. I decided to develop my own using GCP Endpoints that I could keep relatively light-weight.

**Flows / LiveData**
- I decided to use both Flow and LiveData. I used a Flow to gather a stream of Integers to represent the ID numbers of saved Tarot Readings between my data and domain layers, which I then converted into LiveData that the UI could observe.

**Manual Dependency Injection**
- I used an AppContainer to manually inject my dependencies, but I would probably use Hilt/Dagger to manage my dependencies if I were to add a new major feature.
   
**Junit / Espresso / MockK for testing.**
- I wrote a few unit and integration tests as I went along developing my application, but because my application is pretty small, I was able to conduct functional tests using the emulator and finally my own device.
  
ARCHITECTURE

**MVVM / Clean Architecture**
- Architecture was probably the most confusing part about learning Android development - any subversion of MVC did not reall click until I really dug deep into learning SOLID principles. That said, after developing a monstrous 27 function ViewModel that took _minutes_ to parse through, I knew investing the time into learning some kind of architecture (albeit with an imperfect implementation) would eventually pay dividends.

FUTURE IMPROVEMENTS

**DESIGN**
- I'll try to work with an actual UX / UI designer to improve the design of the application. It's not my area of interest.

**FEATURES**
- As I run the gauntlet of 20 testers to try and get this application on the PlayStore, I'll inevitably come across a few new feature requests. I plan to continue working on this application in the future, so if anything stands out, please feel free submit an issue or send me a message!
- 

![Screenshot from 2023-12-09 00-52-07](https://github.com/honeykeys/TheMateriaTarot/assets/73562496/a7b98b09-fb33-41b5-bd97-e6ae41a9b6b6)
![Screenshot from 2023-12-09 00-52-39](https://github.com/honeykeys/TheMateriaTarot/assets/73562496/36436aed-033b-4942-8ec4-6285bdf974dc)
![Screenshot from 2023-12-09 00-53-08](https://github.com/honeykeys/TheMateriaTarot/assets/73562496/9ca9a8f7-f00a-4e0f-af31-a443d00dddd0)


I go into further detail about my design decisions and my learning journey in this blog.

Cheers!
