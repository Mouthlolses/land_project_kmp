package org.francalandproject.project.model

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
    val clientFileDoc: String,

    val propertyPrice: String,
    val entryInstallment: String? = null,
    val valueOfMonthlyInstallments: String,
    val datesForMonthlyInstallments: String,
    val paymentFrequencyForInstallments: String,
    val numberOfInstallments: String
    )
