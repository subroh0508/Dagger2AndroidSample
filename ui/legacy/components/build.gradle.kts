plugins {
    `android-ui-legacy`
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(Libraries.Dagger2.core)

    implementation(Libraries.Dagger2.hilt)
    kapt(Libraries.Dagger2.hiltCompiler)
}
