package com.niran.cryptocurrency.data.remote

import com.niran.cryptocurrency.data.remote.responses.coin_detail.CoinDetailDto
import com.niran.cryptocurrency.data.remote.responses.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto
}