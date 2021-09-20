package net.subroh0508.dagger2sample.legacy.dagger.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import net.subroh0508.dagger2sample.legacy.components.di.FragmentScope
import net.subroh0508.dagger2sample.legacy.components.view.AnimeAbstractsAdapter
import net.subroh0508.dagger2sample.legacy.components.viewmodel.SearchAnimeViewModel
import net.subroh0508.dagger2sample.legacy.dagger.SearchAnimeWithDaggerFragment
import net.subroh0508.dagger2sample.repository.AnimeRepository

@Module
abstract class SearchAnimeWithDaggerFragmentModule {
    companion object {
        @FragmentScope
        @Provides
        fun provideSearchAnimeViewModel(
            fragment: SearchAnimeWithDaggerFragment,
            repository: AnimeRepository,
        ) = ViewModelProvider(
            fragment,
            SearchAnimeViewModel.Factory(
                repository,
            )
        )[SearchAnimeViewModel::class.java]

        @FragmentScope
        @Provides
        fun provideAnimeAbstractsAdapter(
            fragment: SearchAnimeWithDaggerFragment,
            viewModel: SearchAnimeViewModel,
        ) = AnimeAbstractsAdapter(fragment.layoutInflater, viewModel)
    }
}
