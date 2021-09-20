package net.subroh0508.dagger2sample.basecomponents

import android.app.Application
import net.subroh0508.dagger2sample.basecomponents.di.CoreComponent

interface CoreComponentProvider {
    val coreComponent: CoreComponent
}

val Application.coreComponent get() = (this as CoreComponentProvider).coreComponent
