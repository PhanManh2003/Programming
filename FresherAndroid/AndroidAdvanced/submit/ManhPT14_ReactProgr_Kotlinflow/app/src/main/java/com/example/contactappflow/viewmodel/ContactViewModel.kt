package com.example.contactappflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactappflow.data.local.Contact
import com.example.contactappflow.data.repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalCoroutinesApi::class)
class ContactViewModel(
    private val repository: ContactRepository
) : ViewModel() {

    // Query người dùng nhập vào ô search
    private val searchQuery = MutableStateFlow("")

    // Danh sách contact hiển thị, tự động đổi theo searchQuery
    val contacts: StateFlow<List<Contact>> =
        searchQuery
            .debounce(300) // chờ 300ms sau khi ngừng gõ mới search, tránh query liên tục
            .distinctUntilChanged()
            .flatMapLatest { query ->
                if (query.isBlank()) {
                    repository.getAllContacts()
                } else {
                    repository.search(query)
                }
            }
            .catch { e ->
                _error.value = "Failed to load contacts: ${e.message}"
                emit(emptyList())
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _actionSuccess = MutableStateFlow<String?>(null)
    val actionSuccess: StateFlow<String?> = _actionSuccess

    fun searchContacts(query: String) {
        searchQuery.value = query
    }

    fun addContact(contact: Contact) {
        if (contact.name.isBlank() || contact.phone.isBlank()) {
            _error.value = "Name and phone cannot be empty"
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.insert(contact)
                _actionSuccess.value = "Contact added"
            } catch (e: Exception) {
                _error.value = "Failed to add contact: ${e.message}"
            }
        }
    }

    fun updateContact(contact: Contact) {
        if (contact.name.isBlank() || contact.phone.isBlank()) {
            _error.value = "Name and phone cannot be empty"
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.update(contact)
                _actionSuccess.value = "Contact updated"
            } catch (e: Exception) {
                _error.value = "Failed to update contact: ${e.message}"
            }
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.delete(contact)
                _actionSuccess.value = "Contact deleted"
            } catch (e: Exception) {
                _error.value = "Failed to delete contact: ${e.message}"
            }
        }
    }

    fun clearError() {
        _error.value = null
    }

    fun clearActionSuccess() {
        _actionSuccess.value = null
    }
}