package com.vancelopes.composecat.domain.usecase

import com.vancelopes.composecat.common.Resource
import com.vancelopes.composecat.domain.model.Cat
import com.vancelopes.composecat.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow

class GetCats (private val catRepository: CatRepository) {
    operator fun invoke(page: Int, limit: Int): Flow<Resource<List<Cat>>> {
        return catRepository.getCats(page, limit)
    }
}