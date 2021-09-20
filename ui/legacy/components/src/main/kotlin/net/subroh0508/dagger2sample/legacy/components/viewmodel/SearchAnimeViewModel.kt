package net.subroh0508.dagger2sample.legacy.components.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import net.subroh0508.dagger2sample.legacy.components.model.LoadState
import net.subroh0508.dagger2sample.legacy.components.model.SearchAnimeUiModel
import net.subroh0508.dagger2sample.repository.AnimeRepository
import javax.inject.Inject

@HiltViewModel
class SearchAnimeViewModel @Inject constructor(
    private val repository: AnimeRepository,
) : ViewModel() {
    private val animeLoadState: MutableStateFlow<LoadState> by lazy { MutableStateFlow(LoadState.Initialize) }

    val uiModel by lazy {
        combine(animeLoadState) { (animeLoadState) -> SearchAnimeUiModel(animeLoadState) }
            .distinctUntilChanged()
            .stateIn(viewModelScope, SharingStarted.Eagerly, SearchAnimeUiModel())
    }

    fun search(firstLetter: String) {
        val job = viewModelScope.launch(start = CoroutineStart.LAZY) {
            runCatching { repository.search(firstLetter) }
                .onSuccess { animeLoadState.value = LoadState.Loaded(it) }
                .onFailure { animeLoadState.value = LoadState.Failed(it) }
        }

        animeLoadState.value = LoadState.Loading(job)
        job.start()
    }

    class Factory(
        private val repository: AnimeRepository,
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            modelClass: Class<T>,
        ): T = SearchAnimeViewModel(repository) as T
    }
}
