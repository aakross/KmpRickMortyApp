package org.example.rickmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.rickmortyapp.ui.core.navigation.Routes
import org.example.rickmortyapp.ui.home.tabs.characters.CharactersScreen
import org.example.rickmortyapp.ui.home.tabs.episodes.EpisodesScreens

@Composable
fun NavigationBottomWrapper(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreens()
        }
        composable(route = Routes.Characteres.route) {
            CharactersScreen()
        }
    }
}