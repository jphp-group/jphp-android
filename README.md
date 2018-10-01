# The JPHP for Android Project [![Build Status](https://travis-ci.org/VenityStudio/jphp-android.svg?branch=dev)](https://travis-ci.org/VenityStudio/jphp-android)
> Tools and libraries for building android apps on jphp

## How it works ?

Plugin for jppm create compiled jar file from your php sources and dependencies. 
This jar file gets into gralde dependencies and gradle build your apk file.

## How to install ?

Install the lasted version of [jppm](https://github.com/jphp-group/jphp/releases) and [JDK 8](https://java.com/ru/download/).
Before install execute this commands:

```bash
cd ./jphp-android-ext && jppm publish --yes
cd ../jppm-android-plugin && jppm publish --yes
```

## How to start new Android Project ?

Create new directiory and execute commands: 

```bash
jppm init # adding app plugin
jppm remove jphp-core && jppm remove jphp-zend-ext # remove not working dependencies
jppm add jppm-android-plugin --dev # add android plugin
jppm android:init # init new android project
```

### Building your project
To build your project use ``jppm android:build`` command.
You can find ``apk`` file in ``build\outputs\apk`` dir.

#### Project tree : 

```
- .venity/
  \- compiler.jar        # jphp compiler
- resources/             # android resources dir
  \- AndroidManifest.xml # android manifest (see android docs)
- src/                   # php sources dir
  \- index.php           # bootsrap php file
- vendor/                # jppm dependencies
  \- ....
- package.php.yml        # jppm project file
- build.gradle           # gradle build script
- gradlew
- gradlew.bat            # gradle starters
```
