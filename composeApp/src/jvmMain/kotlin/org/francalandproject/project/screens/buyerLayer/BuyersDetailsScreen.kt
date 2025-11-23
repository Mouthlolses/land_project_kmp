package org.francalandproject.project.screens.buyerLayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.exemplo.shared.db.Client


@Composable
fun BuyersDetailsScreen(buyer: Client?) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .height(36.dp)
            ) {
                Text(text = buyer?.clientName ?: "Nada encontrado")
            }
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(text = buyer?.clientCpf ?: "Nada Encontrado")
        }
    }
}