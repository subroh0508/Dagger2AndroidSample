package net.subroh0508.dagger2sample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.subroh0508.dagger2sample.basecomponents.CoreComponentProvider
import net.subroh0508.dagger2sample.basecomponents.di.CoreComponent
import net.subroh0508.dagger2sample.basecomponents.di.DaggerCoreComponent

@HiltAndroidApp
class MainApplication : Application(), CoreComponentProvider {
    override lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent.factory().create()
    }
}
