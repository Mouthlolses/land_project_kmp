package org.francalandproject.project.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.francalandproject.project.components.TopBarWithTabs


@Composable
fun HomeScreen(navController: NavController) {

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
                0 -> RegisterClientScreen()
                1 -> ConsultDebitScreen()
                2 -> ContractsActiveScreen()
            }
        }
    }
}