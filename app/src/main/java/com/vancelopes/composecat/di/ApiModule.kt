package com.vancelopes.composecat.di

import com.vancelopes.composecat.BuildConfig
import com.vancelopes.composecat.data.api.CatApiService
import com.vancelopes.composecat.data.api.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    private val interceptor = run {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.apply { logInterceptor.level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(interceptor).addInterceptor(RequestInterceptor()).build()

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): CatApiService =
        Retrofit.Builder().baseUrl(BuildConfig.host).addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build().create(CatApiService::class.java)

}