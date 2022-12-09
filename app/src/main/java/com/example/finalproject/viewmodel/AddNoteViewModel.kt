package com.example.finalproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.database.Notes
import com.example.finalproject.database.NotesDatabaseDao
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddNoteViewModel(val database: NotesDatabaseDao): ViewModel(){
     private suspend fun insert(note: Notes) {
        database.insert(note)
    }
    fun insertIntoDatabase(id:Int, noteDescription:String, noteTitle:String) {
        viewModelScope.launch {
            val newNote = Notes(id, noteTitle,noteDescription, generateDate())
            insert(newNote)
        }
    }

    private fun generateDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        return currentDate
    }
}