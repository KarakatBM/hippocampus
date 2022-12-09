package com.example.finalproject.data
import com.example.finalproject.model.Note

class DatasourseNote {
    fun loadnotes(): List <Note>{
        return listOf<Note>(
            Note("title1","description1","09.12.2022"),
        )
    }
}