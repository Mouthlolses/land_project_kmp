package org.francalandproject.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import francalandproject.composeapp.generated.resources.Res
import francalandproject.composeapp.generated.resources.logofrancasemfundo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(navController: NavController) {
    MaterialTheme {

        var userInputNameRoot by remember { mutableStateOf("") }
        var userInputPasswordRoot by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.White)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painterResource(Res.drawable.logofrancasemfundo),
                contentDescription = null
            )

            Row(
                modifier = Modifier
                    .padding(start = 100.dp, end = 100.dp)
            ) {
                OutlinedTextField(
                    value = userInputNameRoot,
                    onValueChange = { userInputNameRoot = it },
                    label = { Text("Usuário") },
                    singleLine = true,
                    shape = RoundedCornerShape(26.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray
                    ),
                    modifier = Modifier.width(300.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row() {
                OutlinedTextField(
                    value = userInputPasswordRoot,
                    onValueChange = { userInputPasswordRoot = it },
                    label = { Text("Senha") },
                    singleLine = true,
                    shape = RoundedCornerShape(26.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray
                    ),
                    modifier = Modifier.width(300.dp)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Row() {
                Button(
                    onClick = { navController.navigate("homeScreen") }
                ) {
                    Text("Entrar")
                }
            }

        }
    }
}