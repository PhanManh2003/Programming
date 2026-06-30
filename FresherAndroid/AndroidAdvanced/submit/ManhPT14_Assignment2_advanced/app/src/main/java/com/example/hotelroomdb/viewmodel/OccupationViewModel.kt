package com.example.hotelroomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.hotelroomdb.model.Occupation
import com.example.hotelroomdb.model.relation.OccupationDetail
import com.example.hotelroomdb.model.result.ClientExpense
import com.example.hotelroomdb.model.result.YearlyRevenue
import com.example.hotelroomdb.repository.OccupationRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OccupationViewModel(private val repository: OccupationRepository) : ViewModel() {

    val occupationDetails: StateFlow<List<OccupationDetail>> = repository.getAllDetails()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val clientExpenses2023: StateFlow<List<ClientExpense>> = repository.getClientExpenses2023()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val yearlyRevenue: StateFlow<List<YearlyRevenue>> = repository.getYearlyRevenue()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun insert(occupation: Occupation) = viewModelScope.launch { repository.insert(occupation) }
    fun update(occupation: Occupation) = viewModelScope.launch { repository.update(occupation) }
    fun delete(occupation: Occupation) = viewModelScope.launch { repository.delete(occupation) }

    companion object {
        fun factory(repository: OccupationRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    OccupationViewModel(repository) as T
            }
    }
}
