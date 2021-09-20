package net.subroh0508.dagger2sample.basecomponents.di

import dagger.Component
import net.subroh0508.dagger2sample.repository.AnimeRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {
    @Component.Factory
    interface Factory {
        fun create(): CoreComponent
    }

    fun provideAnimeRepository(): AnimeRepository
}
