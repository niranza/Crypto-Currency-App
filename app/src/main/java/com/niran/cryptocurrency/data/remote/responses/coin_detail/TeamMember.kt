package com.niran.cryptocurrency.data.remote.responses.coin_detail


import com.google.gson.annotations.SerializedName

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)