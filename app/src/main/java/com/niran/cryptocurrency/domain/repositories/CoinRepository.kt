package com.niran.cryptocurrency.domain.repositories

import com.niran.cryptocurrency.data.remote.responses.coin_detail.CoinDetailDto
import com.niran.cryptocurrency.data.remote.responses.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}