package com.geektech.pokemons.ui.fragment

import androidx.lifecycle.ViewModel
import com.geektech.pokemons.data.repository.PokemonRepository

class PokemonViewModel(private var pokemonRepository: PokemonRepository
): ViewModel() {

    fun fetchPokemon() = pokemonRepository.fetchPokemon()

}