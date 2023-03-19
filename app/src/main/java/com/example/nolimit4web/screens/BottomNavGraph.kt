package com.example.nolimit4web.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.nolimit4web.BottomBar

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBar.One.route
    ){
        composable(
            route = BottomBar.One.route
        ){
            OneScreen()
        }
        composable(
            route = BottomBar.Two.route
        ){
            Log.d("MyLog", "GGGG")
            TwoScreen()
        }
        composable(
            route = BottomBar.Three.route
        ){
            ThreeScreen()
        }
    }
}