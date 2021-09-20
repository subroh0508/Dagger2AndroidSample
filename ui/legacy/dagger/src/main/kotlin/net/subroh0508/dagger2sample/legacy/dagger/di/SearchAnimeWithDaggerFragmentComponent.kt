package net.subroh0508.dagger2sample.legacy.dagger.di

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import net.subroh0508.dagger2sample.basecomponents.di.CoreComponent
import net.subroh0508.dagger2sample.legacy.components.di.ActivityScope
import net.subroh0508.dagger2sample.legacy.components.di.FragmentScope
import net.subroh0508.dagger2sample.legacy.dagger.SearchAnimeWithDaggerActivity
import net.subroh0508.dagger2sample.legacy.dagger.SearchAnimeWithDaggerFragment

@FragmentScope
@Subcomponent(
    modules = [
        SearchAnimeWithDaggerFragmentModule::class,
    ],
)
interface SearchAnimeWithDaggerFragmentComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: SearchAnimeWithDaggerFragment,
        ): SearchAnimeWithDaggerFragmentComponent
    }

    fun inject(fragment: SearchAnimeWithDaggerFragment)
}
