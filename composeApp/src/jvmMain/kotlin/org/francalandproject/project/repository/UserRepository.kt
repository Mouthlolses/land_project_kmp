package org.francalandproject.project.repository

import com.exemplo.shared.db.AppDatabaseQueries
import com.exemplo.shared.db.User

class UserRepository(private val userQueries: AppDatabaseQueries) {

    fun insertUser(name: String, password: String) {
        userQueries.insertUser(name, password)
    }

    fun getAllUsers(): List<User> {
        return userQueries.selectAllUsers().executeAsList()
    }

    fun login(name: String, password: String): Boolean {
        return userQueries.selectUserByNameAndPassword(name, password).executeAsList().isNotEmpty()
    }

}