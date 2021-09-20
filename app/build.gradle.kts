plugins {
    `android-application`
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":basecomponents"))
    implementation(project(":data:repository"))

    implementation(project(":ui:legacy:components"))
    implementation(project(":ui:legacy:dagger"))
    implementation(project(":ui:legacy:daggerandroid"))
    implementation(project(":ui:legacy:daggerhilt"))

    implementation(Libraries.Jetpack.core)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.constraintLayout)

    implementation(Libraries.Dagger2.androidSupport)
    implementation(Libraries.Dagger2.hilt)
    kapt(Libraries.Dagger2.hiltCompiler)
}
