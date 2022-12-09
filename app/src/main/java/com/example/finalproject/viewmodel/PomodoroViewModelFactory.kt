package com.example.finalproject.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.database.PomodoroDatabaseDao

class PomodoroViewModelFactory(
    private val dataSource: PomodoroDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {

   @Suppress("unchecked_cast")
   override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(PomodoroViewModel::class.java)) {
           return PomodoroViewModel(dataSource, application) as T
       }
       throw IllegalArgumentException("Unknown ViewModel class")
   }
}