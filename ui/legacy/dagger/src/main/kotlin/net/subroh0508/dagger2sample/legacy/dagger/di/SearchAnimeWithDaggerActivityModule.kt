package net.subroh0508.dagger2sample.legacy.dagger.di

import dagger.Module
import dagger.Provides
import net.subroh0508.dagger2sample.legacy.components.di.ActivityScope
import net.subroh0508.dagger2sample.legacy.components.view.SearchAnimeFragmentAdapter
import net.subroh0508.dagger2sample.legacy.dagger.SearchAnimeWithDaggerActivity
import net.subroh0508.dagger2sample.legacy.dagger.SearchAnimeWithDaggerFragment

@Module(
    subcomponents = [
        SearchAnimeWithDaggerFragmentComponent::class,
    ],
)
abstract class SearchAnimeWithDaggerActivityModule {
    companion object {
        @ActivityScope
        @Provides
        fun provideSearchAnimeFragmentAdapter(
            activity: SearchAnimeWithDaggerActivity
        ) = SearchAnimeFragmentAdapter(
            activity,
            activity.letters,
        ) { index -> SearchAnimeWithDaggerFragment(activity.letters[index]) }
    }
}
