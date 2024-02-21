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
import com.app.rediexpress.presentation.screens.scaffold.home.HomeScreen

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()){
//    Scaffold(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Box(modifier = Modifier.padding(it)){
//            NavHost(
//                navController = navController,
//                startDestination = Screen.Home.route,
//                route = "main"
//            ){
//                composable(route = Screen.Home.route){
//                    HomeScreen()
//                }
//            }
//        }
//
//
//    }
}