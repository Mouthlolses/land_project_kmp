package org.francalandproject.project.domain

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter


fun calculateNumberOfInstallments(dataInicialStr: String, dataFinalStr: String): Int {
    if (dataInicialStr.isBlank() || dataFinalStr.isBlank()) return 0

    return try {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val start = LocalDate.parse(dataInicialStr, formatter)
        val end = LocalDate.parse(dataFinalStr, formatter)
        Period.between(start, end).toTotalMonths().toInt()
    } catch (e: Exception) {
        0 // evita crash
    }
}