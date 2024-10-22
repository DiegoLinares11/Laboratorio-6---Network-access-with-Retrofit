package com.uvg.example.lab06api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

// Definir la interfaz de PokeAPI
interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): PokeResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): PokemonDetailsResponse
}
// Modelo para los detalles de los Pokémon
data class PokemonDetailsResponse(
    val sprites: Sprites
)

data class Sprites(
    val front_default: String,
    val back_default: String,
    val front_shiny: String,
    val back_shiny: String
)