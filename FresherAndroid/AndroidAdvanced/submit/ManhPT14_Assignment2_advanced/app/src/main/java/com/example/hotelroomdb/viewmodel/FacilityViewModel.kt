package com.example.hotelroomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.hotelroomdb.model.Facility
import com.example.hotelroomdb.repository.FacilityRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FacilityViewModel(private val repository: FacilityRepository) : ViewModel() {

    val facilities: StateFlow<List<Facility>> = repository.getAllFacilities()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun insert(facility: Facility) = viewModelScope.launch { repository.insert(facility) }
    fun delete(facility: Facility) = viewModelScope.launch { repository.delete(facility) }

    companion object {
        fun factory(repository: FacilityRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    FacilityViewModel(repository) as T
            }
    }
}
