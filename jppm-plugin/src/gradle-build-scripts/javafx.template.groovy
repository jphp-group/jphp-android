buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath 'org.javafxports:jfxmobile-plugin:2.0.8'
    }
}

apply plugin: 'org.javafxports.jfxmobile'

repositories {
    maven {
        name 'gulon'
        url  "http://nexus.gluonhq.com/nexus/content/repositories/releases/" // gluon repository
    }
    mavenLocal()
    jcenter()

}

dependencies {
    androidRuntime 'com.gluonhq:charm-down-core-android:3.5.0'
    compile fileTree(dir: 'build', include: ['*.jar'])
}

jfxmobile {
    javafxportsVersion = '8.60.9'
    downConfig {
        version = '3.8.0'
        plugins 'display', 'lifecycle', 'statusbar', 'storage'
    }
    android {
        compileSdkVersion  = %sdk%
        buildToolsVersion  = %sdk-tools%
        applicationPackage = %package-name%
    }
}

mainClassName = "org.venity.jphp.ext.android.UXAndroidApplication"
