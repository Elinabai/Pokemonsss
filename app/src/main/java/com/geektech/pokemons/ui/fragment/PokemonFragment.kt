package com.geektech.pokemons.ui.fragment

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.pokemons.R
import com.geektech.pokemons.base.BaseFragment
import com.geektech.pokemons.databinding.FragmentPokemonBinding
import com.geektech.pokemons.model.PokemonModel
import com.geektech.pokemons.ui.adapter.PokemonAdapter

class PokemonFragment :
    BaseFragment<PokemonViewModel, FragmentPokemonBinding>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel by viewModels<PokemonViewModel>()
    private val allPokemon = arrayListOf<PokemonModel>()
    private var pokemonAdapter = PokemonAdapter()

    override fun initialise() {
        binding.pokemonRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokemonAdapter
            Toast.makeText(requireContext(), "123456789", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setupObserve() {
        viewModel.fetchPokemon()
        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
            allPokemon.addAll(it)
            pokemonAdapter.submitList(allPokemon)
            pokemonAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), "123456789", Toast.LENGTH_SHORT).show()
        }
    }
}