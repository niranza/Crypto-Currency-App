package com.niran.cryptocurrency.presentation.states

import com.niran.cryptocurrency.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = listOf(),
    val error: String = ""
)