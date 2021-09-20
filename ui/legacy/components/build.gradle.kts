plugins {
    `android-ui-legacy`
}

dependencies {
    implementation(Libraries.Dagger2.core)
    implementation(Libraries.Dagger2.androidSupport)
    kapt(Libraries.Dagger2.compiler)
}
