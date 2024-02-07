package com.sample.myFeeds.di

import com.sample.myFeeds.core.utils.Constants.FEEDS_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(FEEDS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideClient() =
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//            .addInterceptor { chain ->
//                chain.proceed(chain.request().newBuilder().also {
//                    if (preferenceManager.getString(PrefConstants.ACCESS_TOKEN).isNotBlank()) {
//                        it.addHeader(
//                            "Authorization",
//                            "Bearer ${preferenceManager.getString(PrefConstants.ACCESS_TOKEN)}"
//                        )
//                    }
//                }.build())
//            }
            .retryOnConnectionFailure(true)
            .build()
}