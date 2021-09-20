package net.subroh0508.dagger2sample.legacy.daggerandroid.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import net.subroh0508.dagger2sample.basecomponents.di.CoreComponent
import net.subroh0508.dagger2sample.legacy.components.di.ActivityScope
import net.subroh0508.dagger2sample.legacy.daggerandroid.SearchAnimeWithDaggerAndroidActivity

@ActivityScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        SearchAnimeWithDaggerAndroidActivityModule::class,
    ],
    dependencies = [CoreComponent::class]
)
interface SearchAnimeWithDaggerAndroidActivityComponent : AndroidInjector<SearchAnimeWithDaggerAndroidActivity> {
    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance activity: SearchAnimeWithDaggerAndroidActivity,
        ): SearchAnimeWithDaggerAndroidActivityComponent
    }
}
