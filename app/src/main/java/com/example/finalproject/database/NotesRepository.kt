package com.example.finalproject.database

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NotesDatabaseDao) {

	val allNotes: LiveData<List<Notes>> = notesDao.getAllNotes()
	
	//	method for adding the note to our database
	suspend fun insert(note: Notes) {
		notesDao.insert(note)
	}

	suspend fun delete(note: Notes){
		notesDao.delete(note)
	}

	suspend fun update(note: Notes){
		notesDao.update(note)
	}
}
