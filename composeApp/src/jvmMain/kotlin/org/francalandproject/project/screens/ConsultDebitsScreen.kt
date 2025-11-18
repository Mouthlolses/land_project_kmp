package org.francalandproject.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ConsultDebitsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Consulte os débitos pendentes")
    }
}