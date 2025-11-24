package org.francalandproject.project.model

import org.francalandproject.project.StatusPagamento

data class Installment(
    val clientId: Long,
    val dueDate: String,
    val value: String,
    val status: StatusPagamento
)
