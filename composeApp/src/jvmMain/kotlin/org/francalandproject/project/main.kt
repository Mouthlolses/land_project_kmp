package org.francalandproject.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.francalandproject.project.navigation.appMain

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FrancaLandProject",
    ) {
        appMain()
    }
}