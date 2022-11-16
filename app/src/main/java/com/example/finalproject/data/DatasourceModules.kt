package com.example.finalproject.data

import com.example.finalproject.R
import com.example.finalproject.model.Modules


class DatasourceModules {
    fun loadmodules(): List<Modules> {
        return listOf<Modules>(
            Modules(R.string.module1),
            Modules(R.string.module2),
            Modules(R.string.module3),
            Modules(R.string.module4),
            Modules(R.string.module5),
            Modules(R.string.module6),
        )
    }
}