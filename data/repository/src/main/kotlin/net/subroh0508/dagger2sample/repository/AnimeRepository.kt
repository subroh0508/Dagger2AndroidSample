package net.subroh0508.dagger2sample.repository

import net.subroh0508.dagger2sample.data.Anime

interface AnimeRepository {
    suspend fun search(firstLetter: String): List<Anime>
}
