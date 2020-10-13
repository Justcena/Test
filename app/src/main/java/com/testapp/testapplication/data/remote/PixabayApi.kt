package com.testapp.testapplication.data.remote

import com.testapp.testapplication.BuildConfig
import com.testapp.testapplication.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey:String=BuildConfig.API_KEY
    ):Response<ImageResponse>
}