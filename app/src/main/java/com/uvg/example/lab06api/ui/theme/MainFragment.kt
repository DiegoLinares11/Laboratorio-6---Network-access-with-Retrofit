package com.uvg.example.lab06api

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController

@Composable
fun MainFragment(navController: NavController, pokemonViewModel: PokemonViewModel = viewModel()) {
    val pokemonList by pokemonViewModel.pokemonList

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Pokémon List", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        pokemonList.forEach { pokemon ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // Utilizar el NavController pasado como argumento para la navegación
                        navController.navigate("detail/${pokemon.name}")
                    }
                    .padding(8.dp)
            ) {
                Text(pokemon.name)
            }
        }
    }
}


