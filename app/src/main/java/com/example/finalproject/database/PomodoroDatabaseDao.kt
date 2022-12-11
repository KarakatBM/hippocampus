package com.example.finalproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PomodoroDatabaseDao {
    @Insert
     fun insert(key: Keys)

    @Query("SELECT * from keys_table WHERE keyId = :key")
    fun get(key: Long): Keys?

    @Query("DELETE FROM keys_table")
    fun clear()

    @Query("SELECT COUNT(*) from keys_table")
    fun getSize(): Int?
}