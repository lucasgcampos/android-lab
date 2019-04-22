# Android-lab

This is a repository to do some experiments with android development. 

Goals:
- [ ] CI / CD
- [x] Code coverage (JaCoCo)
- [x] Code style (Detekt)
- [ ] Crashlytics 
- [ ] Material theme
- [x] Modularization
- [ ] Tests with `activityScenario`
- [ ] Navigation
- [ ] Robolectric to test custom views
- [x] Kotlin script

### Code style and more... (Detekt)

The Detekt is a tool to "check" code style, code smell, complexity and others things. Basically, it helps to decrease the code review time and keep the same code style. It's a helpful tool when working in teams. For more information: https://arturbosch.github.io/detekt/

### Modularization

At this moment the project have four modules: **app**, **core**, **movies** and **test**. The idea is aggregate more modules soon. We have only three "types" of modules: application, features and libraries.

- **application (':app'):**
 The "puzzle" module, it's responsible to import and connect other modules and build the android application.
 
- **libraries (':core', ':test'):**
  Modules to "share things", currently the only module is **core**, but it have a lot of responsibilities that should be divided in others libraries.  
  
  **IMPORTANT:** the module **test** it's a module to share code used by tests (testImplementation or androidTestImplementation). It NEVER be imported in production environment. 
 
- **features (':movies'):** 
  It's an application feature. Each feature module must depend only of libraries modules, because they should be independent of others features. A feature module could depend of **n** libraries modules.
  