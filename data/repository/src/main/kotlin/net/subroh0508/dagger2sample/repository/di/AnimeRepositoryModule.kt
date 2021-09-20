package net.subroh0508.dagger2sample.repository.di

import dagger.Binds
import dagger.Module
import net.subroh0508.dagger2sample.repository.AnimeRepository
import net.subroh0508.dagger2sample.repository.AnimeRepositoryImpl

@Module
abstract class AnimeRepositoryModule {
    @Binds
    internal abstract fun bindAnimeRepository(repositoryImpl: AnimeRepositoryImpl): AnimeRepository
}
