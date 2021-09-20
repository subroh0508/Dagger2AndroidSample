import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Android {
    const val applicationId = "net.subroh0508.dagger2sample"
    const val versionCode = 1
    const val versionName = "0.0.1"

    object Versions {
        const val compileSdk = 31
        const val minSdk = 26
        const val targetSdk = 31
    }
}

internal fun Project.androidExt(configure: BaseExtension.() -> Unit) = (this as ExtensionAware).extensions.configure("android", configure)

internal fun Project.androidBaseExt() = androidExt {
    compileSdkVersion(Android.Versions.compileSdk)

    defaultConfig {
        minSdk = Android.Versions.minSdk
        targetSdk = Android.Versions.targetSdk
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }

    sourceSets.forEach {
        it.java.setSrcDirs(files("src/${it.name}/kotlin"))
    }
}
