package org.francalandproject.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import francalandproject.composeapp.generated.resources.Res
import francalandproject.composeapp.generated.resources.logofrancasemfundo
import org.francalandproject.project.navigation.appMain
import org.jetbrains.compose.resources.painterResource

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FrancaLandProject",
        icon = painterResource(Res.drawable.logofrancasemfundo)
    ) {
        appMain()
    }
}