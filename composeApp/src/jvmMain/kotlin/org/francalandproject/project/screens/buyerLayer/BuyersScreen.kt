package org.francalandproject.project.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import francalandproject.composeapp.generated.resources.Res
import francalandproject.composeapp.generated.resources.accountCircle
import francalandproject.composeapp.generated.resources.calendarToday
import francalandproject.composeapp.generated.resources.personAdd
import org.francalandproject.project.components.TextField
import org.francalandproject.project.domain.calculateNumberOfInstallments
import org.francalandproject.project.model.Client
import org.francalandproject.project.repository.ClientRepository
import org.jetbrains.compose.resources.painterResource
import java.awt.FileDialog
import java.awt.Frame
import java.io.File
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyersScreen(clientRepository: ClientRepository) {


    //variable of state
    var clients by remember { mutableStateOf(clientRepository.getAllClients()) }

    var clientName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var clientRg by remember { mutableStateOf("") }
    var clientCpf by remember { mutableStateOf("") }
    var clientAddressRoad by remember { mutableStateOf("") }
    var clientHouseNumber by remember { mutableStateOf("") }
    var clientComplement by remember { mutableStateOf("") }
    var clientNeighborhood by remember { mutableStateOf("") }
    var clientCity by remember { mutableStateOf("") }

    var propertyPrice by remember { mutableStateOf("") } // preço do imovel Ex: R$ 55.000,00
    var entryInstallment by remember { mutableStateOf("") }  // valor da parcela de entrada // opcional
    var valueOfMonthlyInstallments by remember { mutableStateOf("") } //  valor das parcelas mensais Ex: R$ 1.527,77
    var datesForMonthlyInstallmentsStart by remember { mutableStateOf("") } // DATAS DE VENCIMENTO DAS PARCELAS MENSAIS Ex: 26/09/25 A 26/09/28 - Inicio Ex: 26/09/25
    var datesForMonthlyInstallmentsEnd by remember { mutableStateOf("") } // DATAS DE VENCIMENTO DAS PARCELAS MENSAIS Ex: 26/09/25 A 26/09/28 - TERMINO Ex: 26/09/28
    var paymentFrequencyForInstallments by remember { mutableStateOf("") } // PERIODICIDADE DE PAGAMENTO DAS PARCELAS - Ex: Mensal

    val numberOfInstallmentsResult: Int =
        calculateNumberOfInstallments( // número de parcelas, dado a partir do calculo das datas de vencimento das parcelas mensais

            dataInicialStr = datesForMonthlyInstallmentsStart,
            dataFinalStr = datesForMonthlyInstallmentsEnd
        )

    var clientPhone by remember { mutableStateOf("") }
    var clientEmail by remember { mutableStateOf("") }

    var selectedFile by remember { mutableStateOf<File?>(null) }
    val scrollState = rememberScrollState()

    val scrollListState = rememberLazyListState()
    val expanded = scrollListState.firstVisibleItemIndex == 0


    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")


    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showSheet = true },
                icon = {
                    Icon(
                        painter = painterResource(Res.drawable.personAdd),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                text = { Text("Cadastrar Comprador", color = Color.White) },
                expanded = expanded,
                containerColor = Color(0xFF1565C0),
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 8.dp
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(clients) { value ->
                Card(
                    onClick = { /* Lógica de clique (ex: abrir detalhes) */ },
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa a largura total para melhor visualização
                        .padding(horizontal = 16.dp, vertical = 8.dp), // Espaçamento mais coeso
                    shape = RoundedCornerShape(12.dp), // Cantos arredondados modernos
                    colors = CardDefaults.cardColors(
                        // Um fundo claro (pode ser Surface, LightGray ou PrimaryContainer)
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp // Elevação mais sutil
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), // Preenchimento interno
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // 1. Ícone de Avatar/Perfil grande (opcional, para destaque visual)
                        Icon(
                            painter = painterResource(Res.drawable.accountCircle),
                            contentDescription = "Ícone de Cliente",
                            tint = MaterialTheme.colorScheme.primary, // Cor de destaque do tema
                            modifier = Modifier
                                .size(48.dp)
                                .padding(end = 16.dp)
                        )

                        // 2. Coluna de Informações
                        Column(
                            modifier = Modifier.weight(1f) // Ocupa o espaço restante
                        ) {
                            // Nome do Cliente - Título
                            Text(
                                text = value.clientName,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            // Data de Vencimento das Parcelas mensais - Subtítulo com Ícone
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.calendarToday),
                                    contentDescription = "Data de vencimento das parcelas mensais",
                                    tint = MaterialTheme.colorScheme.outline, // Cor discreta
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Perído de Pagamento: ${value.datesForMonthlyInstallmentsStart} á ${value.datesForMonthlyInstallmentsEnd}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            //Periocidade de pagamento das parcelas
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.calendarToday),
                                    contentDescription = "Periocidade de pagamento das parcelas",
                                    tint = MaterialTheme.colorScheme.outline, // Cor discreta
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Periocidade do Parcelamento: ${value.paymentFrequencyForInstallments}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            //Vencimento da proxima parcela
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.calendarToday),
                                    contentDescription = "Periocidade de pagamento das parcelas",
                                    tint = MaterialTheme.colorScheme.outline, // Cor discreta
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Vencimento da Próxima Parcela: ",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    if (showSheet) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { showSheet = false }
        ) {
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
                        label = { Text(text = "Nome do Comprador", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "Data de Nascimento", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "RG do Comprador", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "CPF do Comprador", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "Rua / Logradouro", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "Número", fontWeight = FontWeight.Medium) },
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
                    value = clientComplement,
                    onValue = { clientComplement = it },
                    label = { Text(text = "Complemento (opcional)", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "Bairro", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "Cidade", fontWeight = FontWeight.Medium) },
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
                    text = "Informações de compra",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(top = 16.dp))
                TextField(
                    value = propertyPrice,
                    onValue = { propertyPrice = it },
                    label = { Text(text = "Preço do Imóvel", fontWeight = FontWeight.Medium) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
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
                        value = entryInstallment,
                        onValue = { entryInstallment = it },
                        label = {
                            Text(
                                text = "Valor da Parcela de Entrada (Opcional)",
                                fontWeight = FontWeight.Medium
                            )
                        },
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
                        value = valueOfMonthlyInstallments,
                        onValue = { valueOfMonthlyInstallments = it },
                        label = { Text(text = "Valor das Parcelas Mensais", fontWeight = FontWeight.Medium) },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        )
                    )
                }
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = datesForMonthlyInstallmentsStart,
                        onValueChange = { newValue ->
                            val digits = newValue.filter { it.isDigit() }

                            val limited = digits.take(8)

                            val formatted = buildString {
                                for (i in limited.indices) {
                                    append(limited[i])
                                    if (i == 1 || i == 3) append('/')
                                }
                            }
                            datesForMonthlyInstallmentsStart = formatted
                        },
                        label = { Text(text = "Início", fontWeight = FontWeight.Medium) },
                        placeholder = { Text("Ex: 26/09/25") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .width(150.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                    TextField(
                        value = datesForMonthlyInstallmentsEnd,
                        onValueChange = { newValue ->
                            val digits = newValue.filter { it.isDigit() }

                            val limited = digits.take(8)

                            val formatted = buildString {
                                for (i in limited.indices) {
                                    append(limited[i])
                                    if (i == 1 || i == 3) append("/")
                                }
                            }
                            datesForMonthlyInstallmentsEnd = formatted
                        },
                        label = { Text(text = "Término", fontWeight = FontWeight.Medium) },
                        placeholder = { Text("Ex: 26/09/28") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .width(150.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(top = 16.dp))
                Text(
                    "Comprador irá pagar $numberOfInstallmentsResult parcelas mensais de $valueOfMonthlyInstallments",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                    TextField(
                        value = paymentFrequencyForInstallments,
                        onValue = { paymentFrequencyForInstallments = it },
                        label = { Text(text = "Periocidade de Pagamento", fontWeight = FontWeight.Medium) },
                        placeHolder = { Text(text = "Exemplo: Mensal") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
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
                        label = { Text(text = "Telefone", fontWeight = FontWeight.Medium) },
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
                        label = { Text(text = "Email", fontWeight = FontWeight.Medium) },
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
                Button(
                    onClick = {
                        val dialog = FileDialog(null as Frame?, "Selecione um arquivo", FileDialog.LOAD)
                        dialog.isVisible = true
                        dialog.files.firstOrNull()?.let {
                            selectedFile = it
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF1565C0),
                        contentColor = Color.White
                    )
                ) {
                    Text("Selecionar arquivo")
                }
                selectedFile?.let {
                    Text("Arquivo selecionado: ${it.name}")
                }
                Spacer(modifier = Modifier.padding(top = 18.dp))
                Button(
                    onClick = {
                        clientRepository.insertClient(
                            client = Client(
                                clientName = clientName,
                                birthDate = birthDate,
                                clientRg = clientRg,
                                clientCpf = clientCpf,
                                clientAddressRoad = clientAddressRoad,
                                clientHouseNumber = clientHouseNumber,
                                clientComplement = clientComplement,
                                clientNeighborhood = clientNeighborhood,
                                clientCity = clientCity,
                                clientPhone = clientPhone,
                                clientEmail = clientEmail,
                                clientFileDoc = selectedFile?.name ?: "Não encontrado",
                                propertyPrice = propertyPrice,
                                entryInstallment = entryInstallment,
                                valueOfMonthlyInstallments = valueOfMonthlyInstallments,
                                datesForMonthlyInstallmentsStart = datesForMonthlyInstallmentsStart,
                                datesForMonthlyInstallmentsEnd = datesForMonthlyInstallmentsEnd,
                                paymentFrequencyForInstallments = paymentFrequencyForInstallments,
                                numberOfInstallments = numberOfInstallmentsResult.toString()
                            )
                        )
                        clients = clientRepository.getAllClients()
                        showSheet = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF2FC015),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Salvar")
                }
            }
        }
    }
}

