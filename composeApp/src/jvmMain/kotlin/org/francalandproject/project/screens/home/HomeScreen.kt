package org.francalandproject.project.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.francalandproject.project.components.TopBarWithTabs
import org.francalandproject.project.repository.ClientRepository
import org.francalandproject.project.screens.ConsultDebitsScreen
import org.francalandproject.project.screens.ContractsScreen
import org.francalandproject.project.screens.BuyersScreen


@Composable
fun HomeScreen(navController: NavController, clientRepository: ClientRepository) {

    var selectedTab by remember { mutableIntStateOf(0) }


    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        topBar = {
            TopBarWithTabs(
                selectedTabIndex = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                0 -> BuyersScreen(navController,clientRepository)
                1 -> ConsultDebitsScreen()
                2 -> ContractsScreen()
            }
        }
    }
}