package com.example.facebook.data.repository

import com.example.facebook.data.local.dao.UserDao
import com.example.facebook.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    val allUsers: Flow<List<UserEntity>> = userDao.getAllUsers()
    suspend fun login(email: String, password: String): UserEntity? =
        userDao.login(email, password)
    suspend fun findByEmail(email: String): UserEntity? =
        userDao.findByEmail(email)
    suspend fun insertUser(user: UserEntity) =
        userDao.insertUser(user)
    suspend fun updatePassword(email: String, newPassword: String) =
        userDao.updatePassword(email, newPassword)
}