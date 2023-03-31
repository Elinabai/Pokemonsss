package com.geektech.pokemons.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.pokemons.databinding.ItemPokemonBinding
import com.geektech.pokemons.model.PokemonModel

class PokemonAdapter : ListAdapter<PokemonModel, PokemonAdapter.ViewHolder>(
    PokemonDiffCallBack) {

    class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: PokemonModel?) {
            binding.tvPokemon.text = item?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}

object PokemonDiffCallBack : DiffUtil.ItemCallback<PokemonModel>() {
    override fun areItemsTheSame(
        oldItem: PokemonModel,
        newItem: PokemonModel,
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: PokemonModel,
        newItem: PokemonModel,
    ): Boolean {
        return oldItem == newItem
    }
}