package com.example.finalproject.data

import com.example.finalproject.R
import com.example.finalproject.model.Todo

class DatasoureTodo {
    fun loadtodos(): List<Todo> {
        return listOf<Todo>(
            Todo(R.string.todo1),
            Todo(R.string.todo2),
            Todo(R.string.todo3),
            Todo(R.string.todo4),
            Todo(R.string.todo5),
            Todo(R.string.todo6),
        )
    }
}