# FizzBuzz Android App

## Tech stack
- Full kotlin :100:
- JetPack components (lifeCycleRuntinme , ViewModel , fragment-ktx , navigation) to be safe about configuration changes (rotation of screens ) :relaxed:
- Coroutines for manage asynchronious tasks and multithreading (change between main , io thread easly ) be safe :pray:
- testable Kotlin code (unit test, androidTest : fragments) :robot:
- Clean Architecture (data, domain, presentation layers)
- Presentation layer built based on Unidirectional data flow (UDF) and single entry points
- Latest AGP 7.0.2 ( be sure to setup Jvm 11) :warning:
- Dagger Hilt (after long time of using dagger , i guess Hilt come with many easy way to create our dependency graph :partying_face:)
- using Unit, Instrumentation and Integration tests

## Architecture

#### Clean Architecture Project
This is simple project consists of displaying form to enter five paramters (integer1, integer2, limit, string1, string2) and display list of result after apply transform operation
the project containes three layer data -> domain (use case) -> presentation (mvvm) , we try to sperate responsability to be able to implement unit/android test easly 

#### Testing strategy

The data layer is tested through of unit tests covering:
- testing the Extension function to transform given index of list to str1 or str2
- Local data source ( Room dao ) using Robelectric

For the domain layer we use usecase ( we inject repository class inside usecase)

Finally the presentation layer is tested using the following strategy
- androidTest for used fragments using fragment scenario api 

## If i have more time
 - add more test to cover Repositories , ViewModel , all fragments and generate coverage rapport using jacoco 
 - Using JetpackCompose to display some views like list of result
 - using StateFlow instead liveData
