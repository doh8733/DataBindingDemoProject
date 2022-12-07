package com.example.databindingdemoproject.batdongbo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    private val BASEURL ="http://batdongsanabc.000webhostapp.com/mob403lab4/"
   private val retrofit =Retrofit
        .Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
    val builder = retrofit.build()
    var api :TodoApi = builder.create(TodoApi::class.java)
}