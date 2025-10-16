package org.example.rickmortyapp.ui.core.navigation

sealed class Routes(val route: String) {
    //El agregarle el data sirve para visualizarlo mejor por los logs a nivel tecnico no cambia nada pero para debuguear sirve mucho
    data object Home : Routes("home")

    //BottomNav
    data object Episodes : Routes("episodes")
    data object Characteres : Routes("characters")
}