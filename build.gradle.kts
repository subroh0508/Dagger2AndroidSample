buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(androidGradlePlugin)
        classpath(kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
