package com.example.reactivecontactapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.reactivecontactapp.data.repository.ContactRepository
import com.example.reactivecontactapp.utils.SchedulerProvider


class ContactViewModelFactory(
    private val repository: ContactRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(repository, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}