package com.example.pokemonapp

import android.app.Application
import com.example.pokemonapp.data.network.PokemonService
import com.example.pokemonapp.data.network.PokemonServiceImpl
import com.example.pokemonapp.data.repository.PokemonRepository

class PokemonApplication : Application() {
    private val pokemonServiceImpl = PokemonServiceImpl(PokemonService.pokemonService)
    val repository = PokemonRepository(pokemonServiceImpl)
}