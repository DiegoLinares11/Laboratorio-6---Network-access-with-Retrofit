package com.uvg.example.lab06api

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter


@Composable
fun DetailFragment(name: String, pokemonViewModel: PokemonViewModel = viewModel()) {
    val pokemonDetails by pokemonViewModel.pokemonDetails

    LaunchedEffect(name) {
        pokemonViewModel.fetchPokemonDetails(name)
    }

    pokemonDetails?.let { details ->
        Column(Modifier.fillMaxSize().padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Front")
                Text("Back")
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Image(
                    painter = rememberImagePainter(details.sprites.front_default),
                    contentDescription = "Front Image",
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = rememberImagePainter(details.sprites.back_default),
                    contentDescription = "Back Image",
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Front Shiny")
                Text("Back Shiny")
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Image(
                    painter = rememberImagePainter(details.sprites.front_shiny),
                    contentDescription = "Front Shiny Image",
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = rememberImagePainter(details.sprites.back_shiny),
                    contentDescription = "Back Shiny Image",
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}


