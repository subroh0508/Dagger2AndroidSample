package net.subroh0508.dagger2sample.legacy.daggerandroid.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import net.subroh0508.dagger2sample.legacy.components.di.ActivityScope
import net.subroh0508.dagger2sample.legacy.components.di.FragmentScope
import net.subroh0508.dagger2sample.legacy.components.view.SearchAnimeFragmentAdapter
import net.subroh0508.dagger2sample.legacy.daggerandroid.SearchAnimeWithDaggerAndroidActivity
import net.subroh0508.dagger2sample.legacy.daggerandroid.SearchAnimeWithDaggerAndroidFragment

@Module
abstract class SearchAnimeWithDaggerAndroidActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [SearchAnimeWithDaggerAndroidFragmentModule::class])
    abstract fun contributeSearchAnimeWithDaggerAndroidFragment(): SearchAnimeWithDaggerAndroidFragment

    companion object {
        @ActivityScope
        @Provides
        fun provideSearchAnimeFragmentAdapter(
            activity: SearchAnimeWithDaggerAndroidActivity
        ) = SearchAnimeFragmentAdapter(
            activity,
            activity.letters,
        ) { index -> SearchAnimeWithDaggerAndroidFragment(activity.letters[index]) }
    }
}
