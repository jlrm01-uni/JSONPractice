package com.example.jsonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jsonpractice.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var notesCollection: NotesCollection = NotesCollection()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addNoteButton.setOnClickListener {
            addNote()
        }

    }

    fun loadNotes() {

    }

    fun saveNotes() {
        val jsonString = Gson().toJson(notesCollection)

        val file = File(filesDir, "all_notes.json")
        file.writeText(jsonString)

        Toast.makeText(this, "Notes Saved!", Toast.LENGTH_LONG).show()
    }

    fun deleteEverything() {

    }

    fun displayNotes() {

    }

    fun addNote() {
        val noteSubject = binding.subjectEditText.text.toString()
        val noteContent = binding.contentEditText.text.toString()

        if (noteSubject == "" || noteContent == "") {
            Toast.makeText(this, "Field Missing!", Toast.LENGTH_LONG).show()
            return
        }

        val newNote = Notes()
        newNote.setSubject(noteSubject)
        newNote.setContent(noteContent)

        notesCollection.addNote(newNote)

        saveNotes()
        displayNotes()
        clearFields()
    }

    fun clearFields() {

    }
}