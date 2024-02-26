package com.app.rediexpress.presentation.navgraph

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Welcome : Screen(route = "welcomeScreen")

    data object SignUp : Screen(route = "signUpScreen")
    data object Login : Screen(route = "loginScreen")
    data object ForgotPassword : Screen(route = "forgotPasswordScreen")
    data object OTP : Screen(route = "OTPScreen")
    data object NewPassword : Screen(route = "NewPasswordScreen")

    data object Home : Screen(route = "homeScreen")
    data object Wallet : Screen(route = "walletScreen")
    data object Track : Screen(route = "trackScreen")
    data object Profile : Screen(route = "profileScreen")

    data object AppStartNavigation : Screen(route = "appStartNavigation")
    data object AuthNavigation : Screen(route = "authNavigation")
    data object MainNavigation : Screen(route = "mainNavigation")
}