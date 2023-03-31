package com.geektech.pokemons

import android.app.Application
import com.geektech.pokemons.data.remote.RetrofitClient
import com.geektech.pokemons.data.remote.apiservices.PokemonApiServices
import dagger.hilt.android.HiltAndroidApp

class App: Application() {

    companion object{
//        var pokemonApiServices: PokemonApiServices? = null
        val retrofitClient = RetrofitClient().providePokemonApiServices()
    }

    override fun onCreate() {
        super.onCreate()
//        pokemonApiServices = RetrofitClient().providePokemonApiServices()
    }
}