package com.example.finalproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "keys_table")
data class Keys(
       @PrimaryKey(autoGenerate = true)
       var keyId: Long = 0L
)