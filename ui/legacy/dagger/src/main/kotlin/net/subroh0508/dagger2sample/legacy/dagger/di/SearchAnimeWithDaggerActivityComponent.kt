package net.subroh0508.dagger2sample.legacy.dagger.di

import dagger.BindsInstance
import dagger.Component
import net.subroh0508.dagger2sample.basecomponents.di.CoreComponent
import net.subroh0508.dagger2sample.legacy.components.di.ActivityScope
import net.subroh0508.dagger2sample.legacy.dagger.SearchAnimeWithDaggerActivity

@ActivityScope
@Component(
    modules = [
        SearchAnimeWithDaggerActivityModule::class,
    ],
    dependencies = [CoreComponent::class]
)
interface SearchAnimeWithDaggerActivityComponent {
    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance activity: SearchAnimeWithDaggerActivity,
        ): SearchAnimeWithDaggerActivityComponent
    }

    val searchAnimeWithDaggerFragmentComponentFactory: SearchAnimeWithDaggerFragmentComponent.Factory

    fun inject(activity: SearchAnimeWithDaggerActivity)
}
