package org.francalandproject.project

import androidx.compose.ui.window.Window
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

    val dbPath = System.getProperty("user.home") + "\\AppData\\Local\\FrancaLandProject\\app.db"
    File(dbPath).parentFile?.mkdirs()

    val driver = JdbcSqliteDriver("jdbc:sqlite:$dbPath")
    try {
        AppDatabase.Schema.create(driver)
    } catch (_: Exception) {}

    val database = AppDatabase(driver)
    val userRepository = UserRepository(database.appDatabaseQueries)
    val clientRepository = ClientRepository(database.appDatabaseQueries)

    Window(
        onCloseRequest = ::exitApplication,
        title = "FrancaLandProject",
        icon = painterResource(Res.drawable.icon)
    ) {
        appMain(userRepository, clientRepository)
    }
}