plugins {
    `android-ui-legacy`
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":basehiltcomponents"))
    implementation(project(":ui:legacy:components"))

    implementation(Libraries.Dagger2.hilt)
    kapt(Libraries.Dagger2.hiltCompiler)
}
