package com.app.rediexpress.presentation.navgraph

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object WelcomeScreen : Route(route = "welcomeScreen")

    data object HomeScreen : Route(route = "homeScreen")


    data object AppStartNavigation : Route(route = "appStartNavigation")

    data object NewsNavigation : Route(route = "newsNavigation")
}