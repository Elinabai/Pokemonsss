package com.geektech.pokemons.ui.fragment

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.pokemons.App
import com.geektech.pokemons.data.repository.PokemonRepository
import com.geektech.pokemons.model.PokemonModel
import javax.inject.Inject

class PokemonViewModel : ViewModel() {

    private var pokemonRepository = PokemonRepository(App.retrofitClient)
    private val _pokemonLiveData = MutableLiveData<List<PokemonModel>>()

    val pokemonLiveData: LiveData<List<PokemonModel>> = _pokemonLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    init {
        Log.e(ContentValues.TAG, "View Model create")
    }

    fun fetchPokemon() {
        pokemonRepository.fetchPokemon(
            onSuccess = {
                _pokemonLiveData.value = it
            },
            onFailure = {
                _errorLiveData.value = it
            })
    }
}