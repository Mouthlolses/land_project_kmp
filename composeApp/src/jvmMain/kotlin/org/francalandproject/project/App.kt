package org.francalandproject.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import francalandproject.composeapp.generated.resources.Res
import francalandproject.composeapp.generated.resources.logofrancasemfundo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.francalandproject.project.repository.UserRepository
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(navController: NavController, userRepository: UserRepository) {

    MaterialTheme {

        var userInputNameRoot by remember { mutableStateOf("") }
        var userInputPasswordRoot by remember { mutableStateOf("") }
        val snackBarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(Res.drawable.logofrancasemfundo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(250.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(start = 100.dp, end = 100.dp)
                ) {
                    OutlinedTextField(
                        value = userInputNameRoot.trim(),
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
                        value = userInputPasswordRoot.trim(),
                        onValueChange = { userInputPasswordRoot = it },
                        label = { Text("Senha") },
                        singleLine = true,
                        shape = RoundedCornerShape(26.dp),
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Gray),
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.width(300.dp)
                    )
                }
                Spacer(modifier = Modifier.height(48.dp))
                Button(
                    onClick = {
                        scope.launch {
                            val success = withContext(Dispatchers.IO) {
                                userRepository.login(userInputNameRoot, userInputPasswordRoot)
                            }
                            when {
                                success -> navController.navigate("onBoardingScreen")
                                else -> snackBarHostState.showSnackbar("Usuário ou senha incorretos")
                            }
                        }
                    },
                    modifier = Modifier
                        .size(width = 240.dp, height = 48.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF1565C0))
                ) {
                    Text("Entrar")
                }
            }
        }
    }
}