package com.example.hotelroomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.hotelroomdb.model.Client
import com.example.hotelroomdb.repository.ClientRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClientViewModel(private val repository: ClientRepository) : ViewModel() {

    val clients: StateFlow<List<Client>> = repository.getAllClients()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun insert(client: Client) = viewModelScope.launch { repository.insert(client) }
    fun update(client: Client) = viewModelScope.launch { repository.update(client) }
    fun delete(client: Client) = viewModelScope.launch { repository.delete(client) }

    companion object {
        fun factory(repository: ClientRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    ClientViewModel(repository) as T
            }
    }
}
