package com.geektech.pokemons.data.repository

import androidx.lifecycle.MutableLiveData
import com.geektech.pokemons.data.remote.apiservices.PokemonApiServices
import com.geektech.pokemons.model.PokemonModel
import com.geektech.pokemons.model.PokemonResponse
import retrofit2.Call
import retrofit2.Response

class PokemonRepository(private val pokemonApiServices: PokemonApiServices) {

    fun fetchPokemon(
    ): MutableLiveData<PokemonResponse<PokemonModel>> {
        val data: MutableLiveData<PokemonResponse<PokemonModel>> = MutableLiveData()
        pokemonApiServices.fetchPokemonApiServices()
            .enqueue(object : retrofit2.Callback<PokemonResponse<PokemonModel>> {
                override fun onResponse(
                    call: Call<PokemonResponse<PokemonModel>>,
                    response: Response<PokemonResponse<PokemonModel>>,
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<PokemonResponse<PokemonModel>>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }
}