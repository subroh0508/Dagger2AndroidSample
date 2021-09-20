package net.subroh0508.dagger2sample.repository

import net.subroh0508.dagger2sample.data.Anime
import net.subroh0508.dagger2sample.repository.api.DBPediaApi
import net.subroh0508.dagger2sample.repository.api.buildQueryForAnimeFromFirstLetter
import net.subroh0508.dagger2sample.repository.api.json.DBPediaResponse
import javax.inject.Inject

internal class AnimeRepositoryImpl @Inject constructor(
    private val dbPediaApi: DBPediaApi,
) : AnimeRepository {
    override suspend fun search(
        firstLetter: String,
    ) = dbPediaApi.sparql(buildQueryForAnimeFromFirstLetter(firstLetter)).toEntity()

    private fun DBPediaResponse.toEntity() = results.bindings.map {
        Anime(it.id.value.toLong(), it.title.value, it.abstract.value, it.wikipedia.value)
    }
}
