package org.example.rickmortyapp.ui.home

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.savedstate.savedState
import org.example.rickmortyapp.ui.core.navigation.bottomnavigation.BottomBarItem
import org.example.rickmortyapp.ui.core.navigation.bottomnavigation.BottomBarItem.*
import org.example.rickmortyapp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper

@Composable
fun HomeScreen() {
//    val items = listOf(BottomBarItem.Episodes(), BottomBarItem.Characters()) //Aqui importamos para hacer mas corto el nombre solo se le agrego el ".*"
    val items = listOf(Episodes(), Characters())
    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomNavigation(items, navController) }) {
        NavigationBottomWrapper(navController)
    }
}

//No se agrego al core ya que no es un componente generico asi que no tendria sentido, por esa razon se queda en HomeScreen ya que solo se usara en este componente
@Composable
fun BottomNavigation(items: List<BottomBarItem>, navController: NavHostController) {
    val navBarStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBarStackEntry?.destination

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                label = { Text(item.title) },
                onClick = {
                    navController.navigate(route = item.route) {
                        //Con el graph accedemos a todo el stack de navegacion que hemos hecho, con el startDestinationRoute(El startDestination es de donde se creo osea la primera vista) y con el ? le decimos que si no es nulo va acceder al popUpTo que es ir al inicio de donde comenzo la navegacion
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                //Y aqui guardamos el estado para que la vista no se tenga que volver a recrear
                                saveState = true
                            }
                        }
                        //El launchsingletop a true con esto evitamos que si el usuario le esta picando muchas veces a un boton de navegacion so
                        launchSingleTop = true
                        //Restauramos el estado cada que sea necesario, lo que quiso decir es que si volvemos atras a una vista anterior y ya teniamos un estado le decimos que lo recupere y lo va a restaurar
                        restoreState = true
                    }
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                alwaysShowLabel = false
            )
        }
    }
}