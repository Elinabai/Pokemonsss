package com.geektech.pokemons.data.repository

import com.geektech.pokemons.data.remote.apiservices.PokemonApiServices
import com.geektech.pokemons.model.PokemonModel
import com.geektech.pokemons.model.PokemonResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository (
    private val pokemonApiServices: PokemonApiServices,
) {

    fun fetchPokemon(
        onSuccess: (pokemonList: List<PokemonModel>?) -> Unit,
        onFailure: (message: String) -> Unit,
    ) {
        pokemonApiServices.fetchPokemonApiServices()
            .enqueue(object : retrofit2.Callback<PokemonResponse> {
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>,
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            onSuccess(it.results)
                        }
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    t.localizedMessage?.let {
                        onFailure(it)
                    }
                }
            })
    }
}