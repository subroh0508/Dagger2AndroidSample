plugins {
    `android-library`
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":data:model"))

    implementation(Libraries.Retrofit2.core)
    implementation(Libraries.Retrofit2.converterGson)
    implementation(Libraries.OkHttp3.core)
    implementation(Libraries.OkHttp3.loggingInterceptor)

    implementation(Libraries.gson)

    implementation(Libraries.Dagger2.hilt)
    kapt(Libraries.Dagger2.hiltCompiler)
}
