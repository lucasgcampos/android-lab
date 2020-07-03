# Android-lab

This is a repository to do some experiments with android development. 

Goals:
- [x] [Modularization](#modularization)
- [ ] CI / CD
- [x] [Code style (Detekt)](#code-style-and-more-detekt)
- [x] [Code coverage (JaCoCo)](#jacoco)
- [ ] Crashlytics 
- [ ] Navigation
- [ ] Material theme
- [x] [Kotlin script](#kotlin-script)
- [ ] Tests with `activityScenario`
- [x] [Robolectric](#robolectric)
- [ ] Navigation
- [ ] Robolectric to test custom views
- [x] Kotlin script

### Code style and more... (Detekt)

The Detekt is a tool to "check" code style, code smell, complexity and others things. Basically, it helps to decrease the code review time and keep the same code style. It's a helpful tool when working in teams. For more information: https://arturbosch.github.io/detekt/

The configuration are located in 'tools/detekt'. it's important remember that the file is just the configuration, it's necessary apply it in your project to work correctly.

### Modularization

At this moment the project have four modules: **app**, **core**, **movies** and **test**. The idea is aggregate more modules soon. We have only three "types" of modules: application, features and libraries.

- **application (':app'):**
 The "puzzle" module, it's responsible to import and connect other modules and build the android application.
 
- **libraries (':core', ':test'):**
  Modules to "share things", currently the only module is **core**, but it have a lot of responsibilities that should be divided in others libraries.  
  
  **IMPORTANT:** the module **test** it's a module to share code used by tests (testImplementation or androidTestImplementation). It NEVER be imported in production environment. 
 
- **features (':movies'):** 
  It's an application feature. Each feature module must depend only of libraries modules, because they should be independent of others features. A feature module could depend of **n** libraries modules.
  
  
### Kotlin script

Now android developers can write their scripts using Kotlin! It's great, because it gives us the possibility to use the same language to develop and create our scripts.   

An article that can help to start with this topic is: https://medium.com/mindorks/migrating-gradle-build-scripts-to-kotlin-dsl-89788a4e383a 

### JaCoCo

It's a tool to analyse code coverage. It helps to obtain an overview of which parts of the project are coverage by tests. 

The configuration files are located in "/tools/jacoco/". it's important to remember that these files are just the configuration, it's necessary apply them in your project to work correctly.

### Robolectric

The project are using Robolectric to test custom views. For more information about Robolectric visit: http://robolectric.org/