package com.geektech.pokemons.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geektech.pokemons.R
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}