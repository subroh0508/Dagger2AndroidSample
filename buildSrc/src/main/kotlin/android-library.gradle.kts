plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

androidBaseExt()

dependencies {
    implementation(Libraries.Dagger2.core)
    kapt(Libraries.Dagger2.compiler)
}
