package com.example.finalproject.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.finalproject.database.Notes
import com.example.finalproject.database.NotesDatabase
import com.example.finalproject.database.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(private  val repository : NotesRepository) : ViewModel() {
    val allNotes: LiveData<List<Notes>> = repository.allNotes
    fun deleteNote(note: Notes) = viewModelScope.launch {
        repository.delete(note)
    }

}
class NotesViewModelFactory  (private  val repository : NotesRepository) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            return NotesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}