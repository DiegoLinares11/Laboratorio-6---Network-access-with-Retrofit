package com.uvg.example.lab06api

data class PokeResponse(val results: List<Pokemon>)

// Modelo para el Pokémon (simplificado)
data class Pokemon(
    val name: String,
    val url: String
){
    val id: Int
        get() = url.split("/").filter { it.isNotEmpty() }.last().toInt()
}
