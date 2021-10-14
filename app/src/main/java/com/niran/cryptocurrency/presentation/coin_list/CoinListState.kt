package com.niran.cryptocurrency.presentation.coin_list

import com.niran.cryptocurrency.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = listOf(),
    val error: String = ""
)