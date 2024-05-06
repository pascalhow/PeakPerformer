package com.example.peakperformer.common.data.api

import com.example.peakperformer.common.data.api.model.Athlete

object RestClient {

    private val stravaApiService by lazy {
        StravaApiService.create()
    }

    suspend fun getAthlete(): Athlete {
        return stravaApiService.getAthlete()
    }
}
