package net.subroh0508.dagger2sample.legacy.components.model

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.StateFlow
import net.subroh0508.dagger2sample.data.Anime

data class SearchAnimeUiModel(
    val items: List<Anime> = listOf(),
    val loading: Boolean = false,
    val error: Throwable? = null,
) {
    companion object {
        operator fun invoke(animeLoadState: LoadState) = SearchAnimeUiModel(
            animeLoadState.getValueOrNull() ?: listOf(),
            animeLoadState.loading,
            animeLoadState.getErrorOrNull(),
        )
    }
}

val StateFlow<SearchAnimeUiModel>.itemCount get() = value.items.size
fun StateFlow<SearchAnimeUiModel>.getItem(position: Int) = value.items[position]
fun StateFlow<SearchAnimeUiModel>.getItemId(position: Int) = getItem(position).id

sealed class LoadState {
    object Initialize : LoadState()
    data class Loaded<out T: Any>(val data: T) : LoadState()
    data class Loading(val job: Job): LoadState()
    data class Failed(val error: Throwable): LoadState()

    val loading get() = this is Loading

    @Suppress("UNCHECKED_CAST")
    fun <T: Any> getValueOrNull() = if (this is Loaded<*>) data as T else null
    fun getErrorOrNull() = if (this is Failed) error else null
}
