package com.example.peakperformer.common.data.api

import com.example.peakperformer.common.data.api.model.Athlete
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface StravaApiService {

    @GET("athletes/1370211")
    suspend fun getAthlete(): Athlete

    companion object {
        fun create(): StravaApiService {
            val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

            val interceptor = Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer a5f9916fa57231628aa3bb959dd9b3b79da68491")
                    .build()
                chain.proceed(request)
            }

            val httpClient = OkHttpClient.Builder().apply {
                addInterceptor(interceptor)
            }.build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.strava.com/api/v3/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(httpClient)
                .build()

            return retrofit.create(StravaApiService::class.java)
        }
    }
}
