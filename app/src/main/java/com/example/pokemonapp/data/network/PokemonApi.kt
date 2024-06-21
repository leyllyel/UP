package com.example.pokemonapp.data.network

import com.example.pokemonapp.data.models.PokemonItemsResponse
import com.example.pokemonapp.data.models.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("api/v2/pokemon/")
    suspend fun getPokemons(): Response<PokemonItemsResponse>

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemon(@Path("name") name:String): Response<PokemonResponse>
}
