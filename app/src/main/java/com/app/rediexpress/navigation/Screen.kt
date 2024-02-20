package com.app.rediexpress.navigation

sealed class Screen(
    val route: String
) {
    data object Welcome : Screen("welcome_screen")
    data object Home : Screen("home_screen")
    data object SignUp : Screen("signup_screen")
    data object LogIn : Screen("login_screen")
    data object Main : Screen("login_screen")
}