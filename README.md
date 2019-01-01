# The JPHP for Android Project 
[![Build Status](https://travis-ci.org/VenityStudio/jphp-android.svg?branch=dev)](https://travis-ci.org/VenityStudio/jphp-android)
[![Venity project status](https://img.shields.io/badge/Venity-official-blue.svg)](https://vk.com/venity)
> Tools and libraries for building android apps on jphp

## How it works ?

Plugin for jppm create compiled jar file from your php sources and dependencies. 
This jar file gets into gralde dependencies and gradle build your apk file.

## How to install ?

Install the lasted version of [jppm](https://github.com/jphp-group/jphp/releases) and [JDK 8](https://java.com/ru/download/).
Before install execute command ``jppm build``

## How to start new Android Project ?

Install the lasted version of [Android SDK](https://developer.android.com/studio/#command-tools).
Create new directory and execute commands:

```bash
jppm init                                                # adding app plugin
jppm remove jphp-core && jppm remove jphp-zend-ext       # remove not working dependencies
jppm add jppm-android-plugin --dev                       # add android plugin
jppm android:init                                        # init new android project
```

### Building your project
To build your project use ``jppm android:compile --packageDebug`` command.
You can find ``apk`` file in ``build\outputs\apk`` dir.

#### Project tree : 

```
- .venity/
  - compiler.jar            # jphp compiler
- src/                   
  - main/                   # sources dir
     - jphp/                # php sources dir
        - index.php         # bootstrap php file
     - res/
        - ...           
     - AndroidManifest.xml  # android manifest (see android docs)
- vendor/                   # jppm dependencies
  - ....
- package.php.yml           # jppm project file
- build.gradle              # gradle build script
- gradlew
- gradlew.bat               # gradle starters
```
