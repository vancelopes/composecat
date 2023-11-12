package com.vancelopes.composecat.domain.repository

import com.vancelopes.composecat.common.Resource
import com.vancelopes.composecat.data.api.CatApiService
import com.vancelopes.composecat.domain.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(private val apiService: CatApiService) : CatRepository, BaseRepository() {

    override fun getCats(page: Int, limit: Int): Flow<Resource<List<Cat>>> = flow {
        emit(Resource.Loading())
        when (val cats = safeApiCall { apiService.get(page, limit) }) {
            is Resource.Success -> emit(Resource.Success(cats.data?.map { it.toCat() }))
            is Resource.Error -> emit(Resource.Error(cats.msg!!))
            is Resource.Loading -> emit(Resource.Loading())
        }


    }
}