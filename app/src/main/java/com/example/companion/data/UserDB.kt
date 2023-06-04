package com.example.companion.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Database class with a singleton INSTANCE object.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDB : RoomDatabase() {

    abstract fun userDao(): UserDao

//    companion object {
//        @Volatile
//        private var Instance: UserDB? = null
//
//        fun getDatabase(context: Context): UserDB {
//            // if the Instance is not null, return it, otherwise create a new database instance.
//            return Instance ?: synchronized(this) {
//                Room.databaseBuilder(context, UserDB::class.java, "item_database")
//                    .build()
//                    .also { Instance = it }
//            }
//        }
//    }
}