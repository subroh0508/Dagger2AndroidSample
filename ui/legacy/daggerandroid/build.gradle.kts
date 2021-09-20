plugins {
    `android-ui-legacy`
}

dependencies {
    implementation(project(":ui:legacy:components"))

    implementation(Libraries.Dagger2.core)
    implementation(Libraries.Dagger2.androidSupport)
    kapt(Libraries.Dagger2.compiler)
}
