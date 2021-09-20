package net.subroh0508.dagger2sample.basehiltcomponents.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.subroh0508.dagger2sample.repository.di.AnimeRepositoryModule
import net.subroh0508.dagger2sample.repository.di.DBPediaApiModule

@Module(
    includes = [
        DBPediaApiModule::class,
        AnimeRepositoryModule::class,
    ],
)
@InstallIn(SingletonComponent::class)
abstract class CoreModule
