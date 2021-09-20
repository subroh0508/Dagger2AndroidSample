buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(androidGradlePlugin)
        classpath(kotlinGradlePlugin)
        classpath(Libraries.Dagger2.hiltPlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
