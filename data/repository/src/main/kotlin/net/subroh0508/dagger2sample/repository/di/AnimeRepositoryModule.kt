package net.subroh0508.dagger2sample.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.subroh0508.dagger2sample.repository.AnimeRepository
import net.subroh0508.dagger2sample.repository.AnimeRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class AnimeRepositoryModule {
    @Binds
    internal abstract fun bindAnimeRepository(repositoryImpl: AnimeRepositoryImpl): AnimeRepository
}
