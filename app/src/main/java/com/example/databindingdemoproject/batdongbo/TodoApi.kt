package com.example.databindingdemoproject.batdongbo

import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
    @GET("getall.json")
    suspend fun getAllData():Response<Products>
}