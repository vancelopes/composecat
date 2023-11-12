package com.vancelopes.composecat.data.api

import com.vancelopes.composecat.data.dto.CatDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {
    @GET("v1/images/search?size=small&order=RANDOM")
    suspend fun get(@Query("page") page: Int, @Query("limit") limit: Int): Response<List<CatDto>>
}