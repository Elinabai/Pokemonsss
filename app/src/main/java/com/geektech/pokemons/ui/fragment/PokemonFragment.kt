package com.geektech.pokemons.ui.fragment

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.pokemons.R
import com.geektech.pokemons.base.BaseFragment
import com.geektech.pokemons.databinding.FragmentPokemonBinding
import com.geektech.pokemons.ui.adapter.PokemonAdapter

class PokemonFragment :
    BaseFragment<PokemonViewModel,FragmentPokemonBinding>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel: PokemonViewModel by viewModels()
    private var pokemonAdapter = PokemonAdapter()

    override fun initialise() {
        binding.pokemonRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokemonAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchPokemon().observe(viewLifecycleOwner){
            pokemonAdapter.submitList(it.results)
        }
    }
}