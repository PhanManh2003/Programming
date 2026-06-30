package com.example.hotelroomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.hotelroomdb.model.Room
import com.example.hotelroomdb.model.RoomType
import com.example.hotelroomdb.model.relation.RoomWithType
import com.example.hotelroomdb.repository.RoomRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RoomViewModel(private val repository: RoomRepository) : ViewModel() {

    val roomsWithType: StateFlow<List<RoomWithType>> = repository.getAllRoomsWithType()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val roomTypes: StateFlow<List<RoomType>> = repository.getAllRoomTypes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun insert(room: Room) = viewModelScope.launch { repository.insert(room) }
    fun delete(room: Room) = viewModelScope.launch { repository.delete(room) }

    suspend fun getAvailableRooms(checkIn: String, checkOut: String): List<Room> =
        repository.getAvailableRooms(checkIn, checkOut)

    companion object {
        fun factory(repository: RoomRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    RoomViewModel(repository) as T
            }
    }
}
