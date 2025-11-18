package org.francalandproject.project.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import francalandproject.composeapp.generated.resources.Res
import francalandproject.composeapp.generated.resources.icon
import org.jetbrains.compose.resources.painterResource


@Composable
fun OnBoardingScreen(navController: NavHostController) {

    val optionsList = listOf("Desmembramento 1", "Desmembramento 2", "Desmembramento 3")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(optionsList) { value ->
            Card(
                onClick = { navController.navigate("homeScreen")},
                modifier = Modifier
                    .padding(top = 26.dp, start = 26.dp, end = 26.dp, bottom = 26.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    16.dp
                )
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            alignment = Alignment.Center
                        )
                        Spacer(modifier = Modifier.padding(start = 8.dp))
                        Text(
                            text = value,
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
