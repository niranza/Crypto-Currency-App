package com.niran.cryptocurrency.data.repositories

import com.niran.cryptocurrency.data.remote.CoinPaprikaApi
import com.niran.cryptocurrency.data.remote.responses.coin_detail.CoinDetailDto
import com.niran.cryptocurrency.data.remote.responses.CoinDto
import com.niran.cryptocurrency.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}