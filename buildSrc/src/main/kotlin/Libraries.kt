@Suppress("HardcodedStringLiteral", "unused")
object Libraries {
    object Coroutines {
        private const val version = "1.5.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Jetpack {
        private const val coreVersion = "1.3.2"
        const val core = "androidx.core:core-ktx:$coreVersion"

        private const val appCompatVersion = "1.3.1"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

        private const val activityVersion = "1.4.0-alpha02"
        const val activity = "androidx.activity:activity-ktx:$activityVersion"
        const val activityCompose = "androidx.activity:activity-compose:$activityVersion"

        private const val fragmentVersion = "1.3.6"
        const val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"

        private const val viewPager2Version = "1.0.0"
        const val viewPager2 = "androidx.viewpager2:viewpager2:$viewPager2Version"

        private const val materialVersion = "1.3.0"
        const val material = "com.google.android.material:material:$materialVersion"

        private const val cardViewVersion = "1.0.0"
        const val cardView = "androidx.cardview:cardview:$cardViewVersion"

        private const val constraintLayoutVersion = "2.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

        private const val recyclerViewVersion = "1.2.1"
        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"

        object Compose {
            const val version = "1.1.0-alpha04"

            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val util = "androidx.compose.ui:ui-util:$version"
        }

        object Lifecycle {
            private const val version = "2.3.0"

            const val commonJvm = "androidx.lifecycle:lifecycle-common-java8:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }
    }

    object OkHttp3 {
        private const val version = "4.9.1"
        const val core = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Retrofit2 {
        private const val version = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val converterSerialization = "de.nycode:retrofit2-kotlinx-serialization-converter:0.9.2"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi$version"
    }

    private const val gsonVersion = "2.8.8"
    const val gson = "com.google.code.gson:gson:$gsonVersion"

    private const val serializationVersion = "1.2.2"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"

    private const val moshiVersion = "1.12.0"
    const val moshi = "com.squareup.moshi:moshi-kotlin:$moshiVersion"

    object Dagger2 {
        private const val version = "2.38.1"
        const val core = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"

        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }
}
