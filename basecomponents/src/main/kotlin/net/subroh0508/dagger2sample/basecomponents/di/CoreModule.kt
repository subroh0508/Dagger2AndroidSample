package net.subroh0508.dagger2sample.basecomponents.di

import dagger.Module
import net.subroh0508.dagger2sample.repository.di.AnimeRepositoryModule
import net.subroh0508.dagger2sample.repository.di.DBPediaApiModule

@Module(
    includes = [
        DBPediaApiModule::class,
        AnimeRepositoryModule::class,
    ],
)
abstract class CoreModule
