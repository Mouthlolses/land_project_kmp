package org.francalandproject.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.exemplo.shared.db.AppDatabase
import org.francalandproject.project.App
import org.francalandproject.project.repository.UserRepository
import org.francalandproject.project.screens.HomeScreen

@Composable
fun appMain() {
    val navController = rememberNavController()

    val userRepository = remember {
        val driver = JdbcSqliteDriver("jdbc:sqlite:app.db")
        AppDatabase.Schema.create(driver)
        val database = AppDatabase(driver)
        UserRepository(database.appDatabaseQueries)
    }

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
        composable("homeScreen") {
            HomeScreen(navController)
        }
    }
}