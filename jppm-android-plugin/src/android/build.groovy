apply plugin: 'com.android.application'

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.0'
    }
}

repositories {
    google()
    jcenter()
}

android {
    compileSdkVersion %compileSdkVersion%
    buildToolsVersion "%buildToolsVersion%"

    compileOptions {
        sourceCompatibility 1.8
        targetCompatibility 1.8
    }

    defaultConfig {
        applicationId '%applicationId%'
        minSdkVersion 14
        targetSdkVersion %targetSdkVersion%
        versionCode %versionCode%
        versionName "%versionName%"
    }

    lintOptions {
        abortOnError false
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
}