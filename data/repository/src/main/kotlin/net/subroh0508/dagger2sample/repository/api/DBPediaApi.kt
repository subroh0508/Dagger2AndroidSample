package net.subroh0508.dagger2sample.repository.api

import net.subroh0508.dagger2sample.repository.api.json.DBPediaResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface DBPediaApi {
    @GET("sparql")
    suspend fun sparql(@Query("query") query: String): DBPediaResponse
}
