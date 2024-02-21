package com.app.rediexpress.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.app.rediexpress.presentation.screens.welcome.WelcomeScreen
import com.app.rediexpress.presentation.screens.welcome.WelcomeViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.WelcomeScreen.route
        ) {
            composable(route = Route.WelcomeScreen.route) {
                val viewModel: WelcomeViewModel = hiltViewModel()
                WelcomeScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                Text(text = "TEXT")
            }

        }
    }
}