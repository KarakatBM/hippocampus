package com.example.finalproject.data

import com.example.finalproject.R
import com.example.finalproject.model.Modules


class DatasourceModules {
    fun loadmodules(): List<Modules> {
        return listOf<Modules>(
            Modules(R.string.todo1),
            Modules(R.string.todo2),
            Modules(R.string.todo3),
            Modules(R.string.todo4),
            Modules(R.string.todo5),
            Modules(R.string.todo6),
        )
    }
}