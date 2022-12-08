package com.example.finalproject.database
 
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")

data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "title")
    val noteTitle :String,

    @ColumnInfo(name = "description")
    val noteDescription :String,

    @ColumnInfo(name = "timestamp")
    val timeStamp :String
)