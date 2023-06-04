package com.example.companion.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Int): Flow<User>

    @Query("SELECT email FROM user WHERE email = :email")
    fun getUserByEmail(email: String): String
    @Query("SELECT password FROM user WHERE password = :password")
    fun getUserByPassword(password: String): String

    @Upsert suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}