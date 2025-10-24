package org.francalandproject.project.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import francalandproject.composeapp.generated.resources.Res
import francalandproject.composeapp.generated.resources.logofrancasemfundo
import org.jetbrains.compose.resources.painterResource


@Composable
fun HomeScreen(navController: NavController) {

    val optionsList = listOf("Cadastrar cliente", "Consultar débitos", "Contratos ativos", "Verificações", "Ativos")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(optionsList.size) {
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .fillMaxWidth()
                    .clickable(onClick = { }),
                colors = CardDefaults.cardColors(Color.Gray)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(Res.drawable.logofrancasemfundo),
                            contentDescription = null,
                            modifier = Modifier.height(80.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = optionsList.random(),
                            color = Color.White,
                            fontStyle = FontStyle.Normal,
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}