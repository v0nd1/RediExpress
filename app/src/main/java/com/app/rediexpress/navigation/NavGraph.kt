package com.app.rediexpress.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.rediexpress.presentation.screens.login.LogInScreen
import com.app.rediexpress.presentation.screens.scaffold.home.HomeScreen
import com.app.rediexpress.presentation.screens.signup.SignUpScreen
import com.app.rediexpress.presentation.screens.welcome.WelcomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = Screen.Welcome.route){
            WelcomeScreen(navController)
        }
        navigation(
            startDestination = Screen.SignUp.route,
            route = "auth"
        ){
            composable(route = Screen.SignUp.route){
                SignUpScreen(navController = navController)
            }
            composable(route = Screen.LogIn.route){
                LogInScreen(navController = navController)
            }
        }
        composable(route = Screen.Main.route){


        }

    }
}