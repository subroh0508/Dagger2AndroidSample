plugins {
    `android-application`
    kotlin("android")
}

dependencies {
    implementation(Libraries.Jetpack.core)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.constraintLayout)
}
