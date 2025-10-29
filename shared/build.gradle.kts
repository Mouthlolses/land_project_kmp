plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("app.cash.sqldelight")
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                // put your Multiplatform dependencies here
                implementation("app.cash.sqldelight:runtime:2.0.2")
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("app.cash.sqldelight:sqlite-driver:2.0.2")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.exemplo.shared.db")
        }
    }
}