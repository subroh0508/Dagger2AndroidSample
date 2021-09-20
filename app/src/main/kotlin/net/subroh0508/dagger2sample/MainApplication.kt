package net.subroh0508.dagger2sample

import android.app.Application
import net.subroh0508.dagger2sample.basecomponents.CoreComponentProvider
import net.subroh0508.dagger2sample.basecomponents.di.CoreComponent

class MainApplication : Application(), CoreComponentProvider {
    override lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent
    }
}
