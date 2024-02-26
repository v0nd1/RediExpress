package com.app.rediexpress.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.app.rediexpress.presentation.screens.auth.forgotpass.ForgotPasswordScreen
import com.app.rediexpress.presentation.screens.auth.login.LogInScreen
import com.app.rediexpress.presentation.screens.auth.newpass.NewPasswordScreen
import com.app.rediexpress.presentation.screens.auth.otp.OTPScreen
import com.app.rediexpress.presentation.screens.scaffold.MainScreen
import com.app.rediexpress.presentation.screens.auth.signup.SignUpScreen
import com.app.rediexpress.presentation.screens.welcome.WelcomeScreen
import com.app.rediexpress.presentation.screens.welcome.WelcomeViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Screen.AppStartNavigation.route,
            startDestination = Screen.Welcome.route
        ) {
            composable(route = Screen.Welcome.route) {
                val viewModel: WelcomeViewModel = hiltViewModel()
                WelcomeScreen(
                    onEvent = viewModel::onEvent,
                    navController = navController
                )
            }
        }

        navigation(
            route = Screen.AuthNavigation.route,
            startDestination = Screen.SignUp.route
        ) {
            composable(route = Screen.SignUp.route) {
                SignUpScreen(navController = navController)
            }
            composable(route = Screen.Login.route){
                LogInScreen(navController = navController)
            }
            composable(route = Screen.ForgotPassword.route){
                ForgotPasswordScreen(navController = navController)
            }
            composable(route = Screen.OTP.route){
                OTPScreen(navController = navController)
            }
            composable(route = Screen.NewPassword.route){
                NewPasswordScreen(navController = navController)
            }

        }

        composable(route = Screen.MainNavigation.route){
            MainScreen()
        }
    }
}