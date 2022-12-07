package com.example.finalproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Keys::class], version = 1, exportSchema = false)
abstract class PomodoroDatabase : RoomDatabase() {
    abstract val pomodoroDatabaseDao: PomodoroDatabaseDao
    companion object {

        @Volatile
        private var INSTANCE: PomodoroDatabase? = null

        fun getInstance(context: Context): PomodoroDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PomodoroDatabase::class.java,
                        "pomodoro_keys_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}