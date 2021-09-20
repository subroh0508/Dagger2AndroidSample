plugins {
    `android-application`
}

dependencies {
    implementation(project(":basecomponents"))
    implementation(project(":data:repository"))

    implementation(Libraries.Jetpack.core)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.constraintLayout)
}
