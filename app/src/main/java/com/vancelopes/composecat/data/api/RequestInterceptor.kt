package com.vancelopes.composecat.data.api

import com.vancelopes.composecat.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter("x-api-key", BuildConfig.apiKey)
            .build()
        val request = originalRequest.newBuilder().url(newUrl).build()
        return chain.proceed(request)
    }
}