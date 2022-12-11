package com.example.finalproject.database

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NotesApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { NotesDatabase.getInstance(this) }
    val repository by lazy { NotesRepository(database.notesDatabaseDao()) }
}