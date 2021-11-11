package com.niran.cryptocurrency.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niran.cryptocurrency.common.Resource
import com.niran.cryptocurrency.common.extensions.launchOnce
import com.niran.cryptocurrency.domain.use_cases.GetCoinsUseCase
import com.niran.cryptocurrency.presentation.states.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> get() = _state

    init {
        getCoins()
    }

    private fun getCoins() = getCoinsUseCase().launchOnce(viewModelScope) { result ->
        when (result) {
            is Resource.Loading -> _state.value = CoinListState(isLoading = true)
            is Resource.Success -> _state.value = CoinListState(coins = result.data)
            is Resource.Error -> _state.value = CoinListState(error = result.message)
        }
    }
}