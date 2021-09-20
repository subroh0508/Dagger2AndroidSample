plugins {
    `android-ui-legacy`
}

dependencies {
    implementation(project(":ui:legacy:components"))

    implementation(Libraries.Dagger2.core)
    kapt(Libraries.Dagger2.compiler)
}
