import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    kotlin("plugin.serialization") version "1.9.23"
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.9.6")
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodelCompose)
                implementation(libs.androidx.lifecycle.runtimeCompose)
                implementation(projects.shared)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutinesSwing)

                implementation("app.cash.sqldelight:runtime:2.0.2")
                implementation("app.cash.sqldelight:sqlite-driver:2.0.2")
                implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.1")
                implementation("org.xerial:sqlite-jdbc:3.45.2.0")
            }
        }
    }
}


compose {

    resources {
        publicResClass = true
    }

    desktop {
        application {
            mainClass = "org.francalandproject.project.MainKt"
            buildTypes.release.proguard {
                isEnabled.set(false)
            }
            nativeDistributions {
                targetFormats(TargetFormat.Exe)
                packageName = "FB_Imobiliaria"
                packageVersion = "1.0.0"

                includeAllModules = true
                jvmArgs += listOf("-Dfile.encoding=UTF-8")



                windows {
                    menuGroup = "FrancaLand"
                    upgradeUuid = "1bfe21e7-8b9c-46fd-96d8-1708e4fc73a6"
                    iconFile.set(project.file("src/jvmMain/composeResources/drawable/icon.ico"))
                }
            }
        }
    }
}
