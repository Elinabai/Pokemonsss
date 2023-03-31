package com.geektech.pokemons.data.remote.apiservices

import com.geektech.pokemons.model.PokemonModel
import com.geektech.pokemons.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApiServices {

    @GET("api/v2/pokemon")
    fun fetchPokemonApiServices()
            : Call<PokemonResponse<PokemonModel>>
}