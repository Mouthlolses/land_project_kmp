package org.francalandproject.project.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun TextField(
    value: String,
    onValue: (String) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(26.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValue,
        )
    }

}