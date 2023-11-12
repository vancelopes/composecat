package com.vancelopes.composecat.di

import com.vancelopes.composecat.data.api.CatApiService
import com.vancelopes.composecat.domain.repository.CatRepository
import com.vancelopes.composecat.domain.repository.CatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CatRepositoryModule {

    @Provides
    @Singleton
    fun provideCatRepository(catApiService: CatApiService): CatRepository = CatRepositoryImpl(catApiService)
}