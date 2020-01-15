buildscript {
    repositories {
        maven {
            name 'gulon'
            url  "http://nexus.gluonhq.com/nexus/content/repositories/releases/"
        }

        mavenLocal()
        jcenter()
        google()
    }

    dependencies {
        classpath 'org.javafxports:jfxmobile-plugin:1.3.15'
    }
}

apply plugin: 'org.javafxports.jfxmobile'

repositories {
    maven {
        name 'gulon'
        url  "http://nexus.gluonhq.com/nexus/content/repositories/releases/"
    }

    mavenLocal()
    jcenter()
    google()
}

dependencies {
    androidRuntime 'com.gluonhq:charm-down-core-android:3.8.6'
    compile fileTree(dir: 'libs', include: ['*.jar'])
}

jfxmobile {
    javafxportsVersion = '8.60.12'
    downConfig {
        version = '3.8.6'
        plugins 'browser', 'cache', 'device', 'display', 'lifecycle', 'settings', 'statusbar', 'storage', 'vibration', 'local-notifications'
    }
    android {
        manifest = "./android/AndroidManifest.xml"
        resourcesDirectory =  new java.io.File("./android/")
        androidSdk = "%sdk-path%"
        compileSdkVersion  = %sdk%
        buildToolsVersion  = "%sdk-tools%"
        applicationPackage = "%id%"
    }
}

mainClassName = "org.venity.jphp.ext.android.UXAndroidApplication"

