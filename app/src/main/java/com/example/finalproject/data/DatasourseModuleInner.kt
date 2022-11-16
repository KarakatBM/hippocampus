package com.example.finalproject.data

import com.example.finalproject.R

import com.example.finalproject.model.QuestionAnswer

class DatasourseModuleInner {
    fun loadquestionanswers(): List<QuestionAnswer> {
        return listOf<QuestionAnswer>(
            QuestionAnswer(R.string.card1q,R.string.card1a),
            QuestionAnswer(R.string.card2q,R.string.card2a),
            QuestionAnswer(R.string.card3q,R.string.card3a),
            QuestionAnswer(R.string.card3q,R.string.card3a),
            QuestionAnswer(R.string.card3q,R.string.card3a),
            QuestionAnswer(R.string.card3q,R.string.card3a),
            QuestionAnswer(R.string.card3q,R.string.card3a),
            QuestionAnswer(R.string.card3q,R.string.card3a),
        )
    }

}