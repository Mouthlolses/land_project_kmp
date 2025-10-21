package org.francalandproject.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.francalandproject.project.App
import org.francalandproject.project.screens.HomeScreen

@Composable
fun appMain() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = "appScreen"
    ) {
        composable("appScreen") {
            App(navController)
        }
        composable("homeScreen") {
            HomeScreen(navController)
        }
    }
}