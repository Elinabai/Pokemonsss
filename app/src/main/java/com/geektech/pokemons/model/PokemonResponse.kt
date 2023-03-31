package com.geektech.pokemons.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: ArrayList<T>
)
