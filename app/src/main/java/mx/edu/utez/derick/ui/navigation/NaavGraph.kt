package mx.edu.utez.derick.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utez.derick.ui.screens.conversor.ConversorScreen
import mx.edu.utez.derick.ui.screens.menu.MenuScreen
import mx.edu.utez.derick.ui.screens.propinas.PropinasScreen

// Definición de las rutas de navegación
sealed class Route(val path: String) {
    object Menu : Route("menu")
    object Conversor : Route("conversor")
    object Propinas : Route("propinas")
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Menu.path,
        modifier = modifier
    ) {
        // 1. Pantalla Menú Principal
        composable(Route.Menu.path) {
            MenuScreen(
                onNavigateToConversor = { navController.navigate(Route.Conversor.path) },
                onNavigateToPropinas = { navController.navigate(Route.Propinas.path) }
            )
        }

        // 2. Pantalla Conversor de Divisas
        composable(Route.Conversor.path) {
            ConversorScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        // 3. Pantalla Calculadora de Propinas
        composable(Route.Propinas.path) {
            PropinasScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}