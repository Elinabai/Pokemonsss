package com.geektech.pokemons.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(

        @SerializedName("id")
        val id: Int,

        @SerializedName("name")
        val name: String,

        @SerializedName("height")
        val height: Int,

        @SerializedName("weight")
        val weight: Int,

//        @SerializedName("location_area_encounters")
//        val location_area_encounters: String
)