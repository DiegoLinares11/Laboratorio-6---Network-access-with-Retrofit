package com.uvg.example.lab06api

class PokemonRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getPokemonList(limit: Int) = apiService.getPokemonList(limit)

    suspend fun getPokemonDetails(name: String) = apiService.getPokemonDetails(name)
}
