plugins {
    `android-library`
}

dependencies {
    implementation(project(":data:model"))
    implementation(project(":data:repository"))

    implementation(Libraries.Retrofit2.core)
    implementation(Libraries.OkHttp3.core)
}
