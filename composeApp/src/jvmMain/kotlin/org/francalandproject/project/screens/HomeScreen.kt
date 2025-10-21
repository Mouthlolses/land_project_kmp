package org.francalandproject.project.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {

    val optionsList = listOf("Cadastrar cliente", "Consultar débitos", "Contratos ativos")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(10) {
            Card(
                modifier = Modifier
                    .padding(start = 100.dp, end = 100.dp)
                    .fillMaxWidth()
            ) {

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = optionsList.random()
                )
            }
        }
    }
}