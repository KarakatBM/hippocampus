package com.example.finalproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PomodoroDatabaseDao {
    @Insert
    suspend fun insert(key: Keys)

    @Query("SELECT * from keys_table WHERE keyId = :key")
    suspend fun get(key: Long): Keys?

    @Query("DELETE FROM keys_table")
    suspend fun clear()

    @Query("SELECT COUNT(*) from keys_table")
    suspend fun getSize(): Int?
}