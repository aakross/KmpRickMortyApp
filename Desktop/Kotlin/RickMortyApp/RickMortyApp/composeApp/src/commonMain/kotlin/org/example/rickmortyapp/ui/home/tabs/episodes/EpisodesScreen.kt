package org.example.rickmortyapp.ui.home.tabs.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpisodesScreens() {
//    val name = helloName()
//    Text("Hola $name")
    val episodesViewModel = koinViewModel<EpisodesViewModel>()
    Box(Modifier.fillMaxSize().background(Color.Yellow))
}

//expect fun helloName(): String