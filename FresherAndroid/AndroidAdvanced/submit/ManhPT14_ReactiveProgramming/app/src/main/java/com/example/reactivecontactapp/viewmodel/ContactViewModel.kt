package com.example.reactivecontactapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reactivecontactapp.data.local.Contact
import com.example.reactivecontactapp.data.repository.ContactRepository
import com.example.reactivecontactapp.utils.SchedulerProvider
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ContactViewModel(
    private val repository: ContactRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>> = _contacts

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _actionSuccess = MutableLiveData<String>()
    val actionSuccess: LiveData<String> = _actionSuccess

    init {
        loadContacts()
    }

    fun loadContacts() {
        disposables.add(
            repository.getAllContacts()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                    onNext = { _contacts.value = it },
                    onError = { _error.value = "Failed to load contacts: ${it.message}" }
                )
        )
    }

    fun searchContacts(query: String) {
        if (query.isBlank()) {
            loadContacts()
            return
        }
        disposables.add(
            repository.search(query)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                    onNext = { _contacts.value = it },
                    onError = { _error.value = "Search failed: ${it.message}" }
                )
        )
    }

    fun addContact(contact: Contact) {
        if (contact.name.isBlank() || contact.phone.isBlank()) {
            _error.value = "Name and phone cannot be empty"
            return
        }
        disposables.add(
            repository.insert(contact)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                    onComplete = {
                        _actionSuccess.value = "Contact added"
                        loadContacts()
                    },
                    onError = { _error.value = "Failed to add contact: ${it.message}" }
                )
        )
    }

    fun updateContact(contact: Contact) {
        if (contact.name.isBlank() || contact.phone.isBlank()) {
            _error.value = "Name and phone cannot be empty"
            return
        }
        disposables.add(
            repository.update(contact)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                    onComplete = {
                        _actionSuccess.value = "Contact updated"
                        loadContacts()
                    },
                    onError = { _error.value = "Failed to update contact: ${it.message}" }
                )
        )
    }

    fun deleteContact(contact: Contact) {
        disposables.add(
            repository.delete(contact)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                    onComplete = {
                        _actionSuccess.value = "Contact deleted"
                        loadContacts()
                    },
                    onError = { _error.value = "Failed to delete contact: ${it.message}" }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}