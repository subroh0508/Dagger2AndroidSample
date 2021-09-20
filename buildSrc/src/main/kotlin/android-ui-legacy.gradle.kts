import org.gradle.kotlin.dsl.project

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

androidBaseExt()

android { viewBinding.isEnabled = true }

dependencies {
    implementation(project(":basecomponents"))
    implementation(project(":data:model"))
    implementation(project(":data:repository"))

    implementation(Libraries.Coroutines.core)
    implementation(Libraries.Coroutines.android)

    implementation(Libraries.Jetpack.core)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.fragment)
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.cardView)
    implementation(Libraries.Jetpack.constraintLayout)
    implementation(Libraries.Jetpack.viewPager2)
    implementation(Libraries.Jetpack.recyclerView)

    implementation(Libraries.Jetpack.Lifecycle.commonJvm)
    implementation(Libraries.Jetpack.Lifecycle.viewModel)
}
