package com.uvg.example.lab06api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()

    // State to hold the list of Pokémon
    private val _pokemonList = mutableStateOf<List<Pokemon>>(emptyList())
    val pokemonList: State<List<Pokemon>> = _pokemonList

    // State to hold the details of a specific Pokémon
    private val _pokemonDetails = mutableStateOf<PokemonDetailsResponse?>(null)
    val pokemonDetails: State<PokemonDetailsResponse?> = _pokemonDetails

    init {
        fetchPokemonList()
    }

    // Fetch the list of Pokémon from the API
    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                // Ensure the API call is successful and results are assigned correctly
                val result = repository.getPokemonList(100)
                // Check if result.results is a List<Pokemon> before assigning it
                _pokemonList.value = result.results ?: emptyList() // Handle nullability safely
            } catch (e: Exception) {
                // Handle any error (e.g., log or show a message)
                _pokemonList.value = emptyList() // Set an empty list in case of an error
            }
        }
    }

    // Fetch the details of a specific Pokémon
    fun fetchPokemonDetails(name: String) {
        viewModelScope.launch {
            try {
                val result = repository.getPokemonDetails(name)
                _pokemonDetails.value = result
            } catch (e: Exception) {
                _pokemonDetails.value = null // Handle error if details can't be fetched
            }
        }
    }
}
