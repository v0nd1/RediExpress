package com.app.rediexpress.presentation.screens.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.rediexpress.presentation.navgraph.Screen
import com.app.rediexpress.presentation.screens.scaffold.home.HomeScreen
import com.app.rediexpress.presentation.screens.scaffold.profile.ProfileScreen
import com.app.rediexpress.presentation.screens.scaffold.track.TrackScreen
import com.app.rediexpress.presentation.screens.scaffold.wallet.WalletScreen

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(it)){
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                route = "main"
            ){
                composable(route = Screen.Home.route){
                    HomeScreen(navController = navController)
                }
                composable(route = Screen.Wallet.route){
                    WalletScreen(navController = navController)
                }
                composable(route = Screen.Track.route){
                    TrackScreen(navController = navController)
                }
                composable(route = Screen.Profile.route){
                    ProfileScreen(navController = navController)
                }
            }
        }


    }
}