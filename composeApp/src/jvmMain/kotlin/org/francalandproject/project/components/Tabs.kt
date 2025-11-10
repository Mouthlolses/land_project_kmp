package org.francalandproject.project.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Column {
        val optionsList = listOf("Cadastrar cliente", "Consultar débitos", "Contratos ativos")

        TabRow(selectedTabIndex = selectedTabIndex) {
            optionsList.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index) },
                    text = { Text(title) }
                )
            }
        }
    }
}