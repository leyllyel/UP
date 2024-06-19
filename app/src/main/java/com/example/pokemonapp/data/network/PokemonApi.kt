package com.example.pokemonapp.data.network

import com.example.pokemonapp.data.models.PokemonItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("api/v2/pokemon")
    suspend fun getPokemons(): Response<PokemonItemsResponse>
}