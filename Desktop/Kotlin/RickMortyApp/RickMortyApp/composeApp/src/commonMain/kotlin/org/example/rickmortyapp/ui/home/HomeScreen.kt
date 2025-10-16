package org.example.rickmortyapp.ui.home

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Scaffold(bottomBar = { BottomNavigation() }) {

    }
    Text("Funciono")
}

//No se agrego al core ya que no es un componente generico asi que no tendria sentido, por esa razon se queda en HomeScreen ya que solo se usara en este componente
@Composable
fun BottomNavigation() {
    NavigationBar { }
}