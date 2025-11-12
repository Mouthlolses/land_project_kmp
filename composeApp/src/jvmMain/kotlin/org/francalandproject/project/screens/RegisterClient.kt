package org.francalandproject.project.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.francalandproject.project.components.TextField
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

@Composable
fun RegisterClientScreen() {

    var clientName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var clientRg by remember { mutableStateOf("") }
    var clientCpf by remember { mutableStateOf("") }
    var clientAddressRoad by remember { mutableStateOf("") }
    var clientHouseNumber by remember { mutableStateOf("") }
    var clientComplemente by remember { mutableStateOf("") }
    var clientNeighborhood by remember { mutableStateOf("") }
    var clientCity by remember { mutableStateOf("") }
    var clientPhone by remember { mutableStateOf("") }
    var clientEmail by remember { mutableStateOf("") }


    var selectedFile by remember { mutableStateOf<File?>(null) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Text(
            text = "Cadastro do Comprador",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = clientName,
                onValue = { clientName = it },
                label = { Text(text = "Nome do Comprador") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))
            TextField(
                value = birthDate,
                onValue = { birthDate = it },
                label = { Text(text = "Data de Nascimento") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = clientRg,
                onValue = { clientRg = it },
                label = { Text(text = "RG do Comprador") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))
            TextField(
                value = clientCpf,
                onValue = { clientCpf = it },
                label = { Text(text = "CPF do Comprador") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Text(
            text = "Endereço do Comprador",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(bottom = 4.dp))

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = clientAddressRoad,
                onValue = { clientAddressRoad = it },
                label = { Text(text = "Rua / Logradouro") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))
            TextField(
                value = clientHouseNumber,
                onValue = { clientHouseNumber = it },
                label = { Text(text = "Número") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        TextField(
            value = clientComplemente,
            onValue = { clientComplemente = it },
            label = { Text(text = "Complemento (opcional)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = clientNeighborhood,
                onValue = { clientNeighborhood = it },
                label = { Text(text = "Bairro") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))

            TextField(
                value = clientCity,
                onValue = { clientCity = it },
                label = { Text(text = "Cidade") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Text(
            text = "Meio de Contato",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(bottom = 4.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = clientPhone,
                onValue = { clientPhone = it },
                label = { Text(text = "Telefone") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))

            TextField(
                value = clientEmail,
                onValue = { clientEmail = it },
                label = { Text(text = "Email") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Text(
            text = "Anexe o Contrato",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Button(onClick = {
            val dialog = FileDialog(null as Frame?, "Selecione um arquivo", FileDialog.LOAD)
            dialog.isVisible = true
            dialog.files.firstOrNull()?.let {
                selectedFile = it
            }
        }) {
            Text("Selecionar arquivo")
        }

        selectedFile?.let {
            Text("Arquivo selecionado: ${it.name}")
        }
    }
}