package com.geektech.pokemons.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment< VM : ViewModel,VB : ViewBinding,>(fragmentPokemon: Int) :
    Fragment() {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialise()
        setupListener()
        setupObserve()
    }

    protected open fun initialise() {}

    protected open fun setupListener() {}

    protected open fun setupObserve() {}
}