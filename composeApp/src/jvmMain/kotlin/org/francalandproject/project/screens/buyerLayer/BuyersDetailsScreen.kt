package org.francalandproject.project.screens.buyerLayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.exemplo.shared.db.Client


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyerDetailsScreen(buyer: Client?) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F4F5)) // tom elegante e suave de fundo
            .padding(24.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                // Título
                Text(
                    text = "Informações do Comprador",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF1B1B1B)
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    thickness = 1.dp,
                    color = Color(0xFFE0E0E0)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    // Campo personalizado reutilizável
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        DetailRow(label = "Nome", value = buyer?.clientName)
                        DetailRow(label = "Data de Nascimento", value = buyer?.birthDate)
                        DetailRow(label = "CPF", value = buyer?.clientCpf)
                        DetailRow(label = "RG", value = buyer?.clientRg)
                        DetailRow(label = "Telefone", value = buyer?.clientPhone)
                        DetailRow(label = "E-mail", value = buyer?.clientEmail)
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        DetailRow(label = "Valor do Imóvel", value = buyer?.propertyPrice)
                        DetailRow(label = "Parcelas", value = buyer?.numberOfInstallments)
                        DetailRow(label = "Data Início de Pagamento", value = buyer?.datesForMonthlyInstallmentsStart)
                        DetailRow(label = "Data Final de Pagamento", value = buyer?.datesForMonthlyInstallmentsEnd)
                        DetailRow(label = "Periocidade de Pagamento", value = buyer?.paymentFrequencyForInstallments)
                        DetailRow(label = "Valor das Parcelas Mensais", value = buyer?.valueOfMonthlyInstallments)

                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Situação de Pagamento",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF1B1B1B)
                )
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    thickness = 1.dp,
                    color = Color(0xFFE0E0E0)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    DetailRow(label = "Estado", value = "Estado Aqui")
                }
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String?) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
            color = Color(0xFF6D6D6D)
        )
        Text(
            text = value ?: "Não informado",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF1B1B1B),
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}