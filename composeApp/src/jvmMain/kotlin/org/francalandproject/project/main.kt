package org.francalandproject.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.exemplo.shared.db.AppDatabase
import francalandproject.composeapp.generated.resources.Res
import francalandproject.composeapp.generated.resources.icon
import org.francalandproject.project.navigation.appMain
import org.francalandproject.project.repository.ClientRepository
import org.francalandproject.project.repository.UserRepository
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.painterResource
import java.io.File

@OptIn(InternalResourceApi::class)
fun main() = application {

    val windowState = WindowState(
        placement = WindowPlacement.Fullscreen
    )

    val dbPath = System.getProperty("user.home") + "\\AppData\\Local\\FrancaLandProject\\app.db"
    File(dbPath).parentFile?.mkdirs()

    val dbFile = File(dbPath)
    val isNewDatabase = !dbFile.exists() // <-- testa ANTES

    val driver = JdbcSqliteDriver("jdbc:sqlite:$dbPath")

    if (isNewDatabase) {                // <-- usa a flag
        try {
            AppDatabase.Schema.create(driver)
            println("Banco criado pela primeira vez.")
        } catch (e: Exception) {
            println("Erro ao criar DB: ${e.localizedMessage}")
        }
    }
    val database = AppDatabase(driver)
    val userRepository = UserRepository(database.appDatabaseQueries)
    val clientRepository = ClientRepository(database.appDatabaseQueries)

    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "FrancaLandProject",
        icon = painterResource(Res.drawable.icon)
    ) {
        appMain(userRepository, clientRepository)
    }
}