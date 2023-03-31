package com.geektech.pokemons.model

import com.google.gson.annotations.SerializedName

data class Info(

    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("previous")
    val previous: String
)
