package com.niran.cryptocurrency.domain.repositories

import com.niran.cryptocurrency.data.remote.dto.CoinDetailDto
import com.niran.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}