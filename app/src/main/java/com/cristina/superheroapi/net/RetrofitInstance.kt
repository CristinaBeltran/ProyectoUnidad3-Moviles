package com.cristina.superheroapi.net

import com.cristina.superheroapi.BASE_URL
import com.cristina.superheroapi.net.services.SuperheroService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        @JvmStatic
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @JvmStatic
        val superheroService = retrofit.create(SuperheroService::class.java)
    }
}