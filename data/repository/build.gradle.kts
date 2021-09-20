plugins {
    `android-library`
}

dependencies {
    implementation(project(":data:model"))

    implementation(Libraries.Retrofit2.core)
    implementation(Libraries.Retrofit2.converterGson)
    implementation(Libraries.OkHttp3.core)
    implementation(Libraries.OkHttp3.loggingInterceptor)

    implementation(Libraries.gson)
}
