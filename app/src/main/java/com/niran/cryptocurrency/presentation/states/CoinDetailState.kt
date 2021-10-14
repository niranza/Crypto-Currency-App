package com.niran.cryptocurrency.presentation.states

import com.niran.cryptocurrency.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)