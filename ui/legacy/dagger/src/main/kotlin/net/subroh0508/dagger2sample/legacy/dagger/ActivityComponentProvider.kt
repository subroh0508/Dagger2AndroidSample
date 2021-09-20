package net.subroh0508.dagger2sample.legacy.dagger

import androidx.fragment.app.Fragment
import net.subroh0508.dagger2sample.legacy.dagger.di.SearchAnimeWithDaggerActivityComponent

interface ActivityComponentProvider {
    val activityComponent: SearchAnimeWithDaggerActivityComponent
}

val Fragment.activityComponent get() = (requireActivity() as ActivityComponentProvider).activityComponent
