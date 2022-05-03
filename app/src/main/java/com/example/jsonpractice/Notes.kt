package com.example.jsonpractice

class Notes {
    var note_subject: String? = null
    var note_content: String? = null

    fun setSubject(message: String) {
        note_subject = message
    }

    fun setContent(message: String) {
        note_content = message
    }

    override fun toString(): String {
        return "<subject: $note_subject, content: $note_content>"
    }
}