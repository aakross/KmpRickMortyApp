package org.example.rickmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import org.example.rickmortyapp.ui.core.navigation.Routes

//Esto es como un contrato de como vamos a manejar nuestro bottomBar, cosas que son "necesarias" para que funcione correctamente, no es necesario hacer esto pero es un plus y buenas practicas
sealed class BottomBarItem {
    abstract val route: String
    abstract val title: String
    abstract val icon: @Composable () -> Unit

    //Implementamos los override dejando el cursor sobre el "error", y nos marcaba error porque arriba las declaramos y abajo en Episodes lo implementaremos
    data class Episodes(
        override val route: String = Routes.Episodes.route,
        override val title: String = "Episodes",
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Home , "")

        }
    ) : BottomBarItem()
}

val episode = BottomBarItem.Episodes()