package com.vancelopes.composecat.di

import com.vancelopes.composecat.domain.repository.CatRepository
import com.vancelopes.composecat.domain.usecase.GetCats
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GetCatsModule {

    @Provides
    @Singleton
    fun provideGetCatsModule(repository: CatRepository): GetCats = GetCats(repository)
}