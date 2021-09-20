package net.subroh0508.dagger2sample.repository.di

import dagger.Module
import dagger.Provides
import net.subroh0508.dagger2sample.repository.api.DBPediaApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val DBPEDIA_BASE_URL = "http://ja.dbpedia.org/"

@Module
class DBPediaApiModule {
    @Provides
    internal fun provideDBPediaApi(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): DBPediaApi = Retrofit.Builder()
            .baseUrl(DBPEDIA_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(DBPediaApi::class.java)

    @Provides
    internal fun provideOkHttpClient() = OkHttpClient.Builder()
            .also { client ->
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(loggingInterceptor)
            }.build()

    @Provides
    internal fun providerConverterFactory(): Converter.Factory = GsonConverterFactory.create()
}
