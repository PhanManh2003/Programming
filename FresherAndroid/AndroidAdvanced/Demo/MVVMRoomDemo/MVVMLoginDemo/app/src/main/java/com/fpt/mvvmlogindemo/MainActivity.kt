package com.fpt.mvvmlogindemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var etTitle: EditText
    private lateinit var etContent: EditText
    private lateinit var btnSave: Button
    private lateinit var tvNotesList: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        etTitle = findViewById<EditText>(R.id.etTitle)
        etContent = findViewById<EditText>(R.id.etContent)
        btnSave = findViewById<Button>(R.id.btnSave)
        tvNotesList = findViewById<TextView>(R.id.tvNotesList)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val note = Note(title = title, content = content)
                noteViewModel.insert(note)
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()

                etTitle.text.clear()
                etContent.text.clear()
            } else {
                Toast.makeText(this, "Please input title or content", Toast.LENGTH_SHORT).show()
            }
        }
        observerNotes()
    }

    private fun observerNotes() {
        lifecycleScope.launch {
            noteViewModel.allNotes.collectLatest { notes ->
                val notesText = notes.joinToString(separator = "\n\n") {
                    "ID: ${it.id}\nTitle: ${it.title}\nContent: ${it.content}"
                }
                tvNotesList.text = notesText
            }
        }
    }

}