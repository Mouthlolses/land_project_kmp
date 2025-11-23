package org.francalandproject.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.francalandproject.project.App
import org.francalandproject.project.repository.ClientRepository
import org.francalandproject.project.repository.UserRepository
import org.francalandproject.project.screens.buyerLayer.BuyersDetailsScreen
import org.francalandproject.project.screens.home.HomeScreen
import org.francalandproject.project.screens.onboarding.OnBoardingScreen

@Composable
fun appMain(userRepository: UserRepository, clientRepository: ClientRepository) {
    val navController = rememberNavController()


    LaunchedEffect(Unit) {
        userRepository.insertUser("Matheus", "1234567")
    }

    NavHost(
        navController = navController,
        startDestination = "appScreen"
    ) {
        composable("appScreen") {
            App(navController, userRepository = userRepository)
        }
        composable("onBoardingScreen") {
            OnBoardingScreen(navController)
        }
        composable("homeScreen") {
            HomeScreen(navController, clientRepository)
        }
        composable<BuyerDetailsRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<BuyerDetailsRoute>()
            val buyerId = route.buyerId

            val buyer = clientRepository.getAllClients().find { it.id == buyerId }

            BuyersDetailsScreen(buyer)
        }
    }
}

@Serializable
data class BuyerDetailsRoute(val buyerId: Long)