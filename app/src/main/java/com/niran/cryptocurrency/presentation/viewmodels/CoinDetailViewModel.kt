package com.niran.cryptocurrency.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niran.cryptocurrency.common.Constants.PARAM_COIN_ID
import com.niran.cryptocurrency.common.Resource
import com.niran.cryptocurrency.domain.use_cases.GetCoinUseCase
import com.niran.cryptocurrency.presentation.states.CoinDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    safeStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> get() = _state

    init {
        safeStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) = getCoinUseCase(coinId).onEach { result ->
        when (result) {
            is Resource.Loading -> _state.value = CoinDetailState(isLoading = true)
            is Resource.Success -> _state.value = CoinDetailState(coin = result.data)
            is Resource.Error -> _state.value = CoinDetailState(error = result.message)
        }
    }.launchIn(viewModelScope)
}