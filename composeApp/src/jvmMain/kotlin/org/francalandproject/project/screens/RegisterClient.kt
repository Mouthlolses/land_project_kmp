package org.francalandproject.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.francalandproject.project.components.TextField

@Composable
fun RegisterClientScreen() {

    var clientName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(
            value = clientName,
            onValue = { clientName = it }
        )
    }
}