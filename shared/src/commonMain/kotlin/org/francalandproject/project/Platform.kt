package org.francalandproject.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform