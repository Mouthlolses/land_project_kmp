package org.francalandproject.project.repository

import com.exemplo.shared.db.AppDatabaseQueries
import org.francalandproject.project.model.Client

class ClientRepository(private val clientQueries: AppDatabaseQueries) {

    fun insertClient(client: Client){
        clientQueries.insertClient(
            clientName = client.clientName,
            birthDate = client.birthDate,
            clientRg = client.clientRg,
            clientCpf = client.clientCpf,
            clientAddressRoad = client.clientAddressRoad,
            clientHouseNumber = client.clientHouseNumber,
            clientComplement = client.clientComplement,
            clientNeighborhood = client.clientNeighborhood,
            clientCity = client.clientCity,
            clientPhone = client.clientPhone,
            clientEmail = client.clientEmail,
            clientFileDocPath = client.clientFileDoc,
        )
    }

    fun getAllClients(): List<com.exemplo.shared.db.Client> {
        return clientQueries.selectAllClients().executeAsList()
    }


}