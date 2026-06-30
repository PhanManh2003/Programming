package com.fpt.mvvmlogindemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val noteDao: NoteDao
    val allNotes: Flow<List<Note>>

    init {
        val database = NoteDatabase.getDatabase(application)
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteDao.insert(note)
    }

}