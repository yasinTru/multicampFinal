package com.yasin.multicampFinal.data.model

import retrofit2.http.GET

interface NewsApi {
    @GET("communities")
    suspend fun getCommunities():List<Community>?
}