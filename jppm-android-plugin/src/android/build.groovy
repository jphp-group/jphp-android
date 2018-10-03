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

  defaultConfig {
      applicationId '%applicationId%'
      minSdkVersion 14
      targetSdkVersion %targetSdkVersion%
      versionCode %versionCode%
      versionName "%versionName%"
  }

  compileOptions {
      sourceCompatibility JavaVersion.VERSION_1_8 // JDK 8
      targetCompatibility JavaVersion.VERSION_1_8
  }

  buildTypes {
    release {
        sourceSets {
            main.java.srcDirs = ['src-jvm/java']
            main.resources.srcDirs = ['resources']
            main.manifest.srcFile 'resources/AndroidManifest.xml'
        }

        minifyEnabled false
        //proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
  }

  splits {
    density {
      enable false
      exclude "ldpi", "tvdpi", "xxxhdpi", "400dpi", "560dpi"
    }
  }
  lintOptions {
    abortOnError false
  }
}

dependencies {
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation fileTree(dir: 'libs', include: ['*.jar'])
}