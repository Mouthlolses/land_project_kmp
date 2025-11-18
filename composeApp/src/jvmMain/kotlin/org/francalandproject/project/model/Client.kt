package org.francalandproject.project.model

import java.io.File

data class Client(
    val clientName: String,
    val birthDate: String,
    val clientRg: String,
    val clientCpf: String,
    val clientAddressRoad: String,
    val clientHouseNumber: String,
    val clientComplement: String? = null,
    val clientNeighborhood: String,
    val clientCity: String,
    val clientPhone: String,
    val clientEmail: String,

    // Armazena só o path no banco
    val clientFileDoc: String
)
