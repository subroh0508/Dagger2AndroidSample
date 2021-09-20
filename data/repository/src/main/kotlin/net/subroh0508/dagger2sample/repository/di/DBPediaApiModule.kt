package net.subroh0508.dagger2sample.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.subroh0508.dagger2sample.repository.api.DBPediaApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val DBPEDIA_BASE_URL = "http://ja.dbpedia.org/"

@Module
@InstallIn(SingletonComponent::class)
class DBPediaApiModule {
    @Provides
    internal fun provideDBPediaApi(): DBPediaApi {
        val okHttpClient = OkHttpClient.Builder()
            .also { client ->
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(loggingInterceptor)
            }.build()

        val converterFactory = GsonConverterFactory.create()

        return Retrofit.Builder()
            .baseUrl(DBPEDIA_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(DBPediaApi::class.java)
    }
}
