package com.vancelopes.composecat.domain.repository

import com.vancelopes.composecat.common.Resource
import com.vancelopes.composecat.domain.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getCats(page: Int, limit: Int): Flow<Resource<List<Cat>>>
}