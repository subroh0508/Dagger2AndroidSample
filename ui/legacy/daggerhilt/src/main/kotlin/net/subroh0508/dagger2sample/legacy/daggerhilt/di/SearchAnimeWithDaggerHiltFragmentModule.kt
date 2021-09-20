package net.subroh0508.dagger2sample.legacy.daggerhilt.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import net.subroh0508.dagger2sample.legacy.components.di.FragmentScope
import net.subroh0508.dagger2sample.legacy.components.view.AnimeAbstractsAdapter
import net.subroh0508.dagger2sample.legacy.components.viewmodel.SearchAnimeViewModel
import net.subroh0508.dagger2sample.repository.AnimeRepository

@Module
@InstallIn(FragmentComponent::class)
class SearchAnimeWithDaggerHiltFragmentModule {
    @Provides
    fun provideSearchAnimeViewModel(
        fragment: Fragment,
        repository: AnimeRepository,
    ) = ViewModelProvider(
        fragment,
        SearchAnimeViewModel.Factory(
            repository,
        )
    )[SearchAnimeViewModel::class.java]

    @Provides
    fun provideAnimeAbstractsAdapter(
        fragment: Fragment,
        viewModel: SearchAnimeViewModel,
    ) = AnimeAbstractsAdapter(fragment.layoutInflater, viewModel)
}
