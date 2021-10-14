package com.niran.cryptocurrency.domain.models

import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
