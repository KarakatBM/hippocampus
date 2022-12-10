package com.example.finalproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.finalproject.database.Notes
import com.example.finalproject.database.NotesDatabase
import com.example.finalproject.database.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel (application: Application): AndroidViewModel(application) {

//	val allNotes : LiveData<List<Notes>>
//	val repository : NotesRepository

//	init {
////		val dao = NotesDatabase.getInstance(application).notesDatabaseDao()
////		repository = NotesRepository(dao)
////		allNotes = repository.allNotes
//	}

//	fun deleteNote (note: Notes) = viewModelScope.launch {
//		repository.delete(note)
//	}
//
//	fun updateNote(note: Notes) = viewModelScope.launch {
//	repository.update(note)
//	}

//	fun addNote(note: Notes) = viewModelScope.launch{
//		repository.insert(note)
//	}
}
