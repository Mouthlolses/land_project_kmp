package org.francalandproject.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import org.francalandproject.project.components.TextField

@Composable
fun RegisterClientScreen() {

    var clientName by remember { mutableStateOf("") }
    var clientAge by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = clientName,
            onValue = { clientName = it }
        )
        TextField(
            value = clientAge,
            onValue = { clientAge = it },
            label = { Text(text = "Idade") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}