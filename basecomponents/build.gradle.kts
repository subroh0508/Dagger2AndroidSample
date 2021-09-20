plugins {
    `android-library`
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":data:model"))
    implementation(project(":data:repository"))

    implementation(Libraries.Retrofit2.core)
    implementation(Libraries.OkHttp3.core)

    implementation(Libraries.Dagger2.hilt)
    kapt(Libraries.Dagger2.hiltCompiler)
}
