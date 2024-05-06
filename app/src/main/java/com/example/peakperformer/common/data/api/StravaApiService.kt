package com.example.peakperformer.common.data.api

import com.example.peakperformer.common.data.api.model.Athlete
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface StravaApiService {

    @GET("athletes/1370211")
    suspend fun getAthlete(): Athlete

    companion object {
        fun create(): StravaApiService {
            val moshi = Moshi.Builder().build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.strava.com/api/v3/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

            return retrofit.create(StravaApiService::class.java)
        }
    }
}
