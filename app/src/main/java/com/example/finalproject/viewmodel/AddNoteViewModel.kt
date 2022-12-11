package com.example.finalproject.viewmodel

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.*
import com.example.finalproject.database.Notes
import com.example.finalproject.database.NotesDatabase
import com.example.finalproject.database.NotesDatabaseDao
import com.example.finalproject.database.NotesRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddNoteViewModel(private  val repository : NotesRepository) : ViewModel() {


    val allNotes: LiveData<List<Notes>> = repository.allNotes
//    private val _isValid = MutableLiveData<Boolean>(false)
//    val isValid: LiveData<Boolean> // To observe the value outside the ViewModel class.
//        get() = _isValid

//     private suspend fun insert(note: Notes) {
////         _isValid.postValue(true)
//         repository.insert(note)
//    }
//      fun insert(id:Int, noteDescription:String, noteTitle:String) {
//        viewModelScope.launch {
//            val newNote = Notes(id, noteTitle,noteDescription, generateDate())
//            repository.insert(newNote)
//        }

        fun insert(note: Notes) = viewModelScope.launch {
            repository.insert(note)
        }
    }


