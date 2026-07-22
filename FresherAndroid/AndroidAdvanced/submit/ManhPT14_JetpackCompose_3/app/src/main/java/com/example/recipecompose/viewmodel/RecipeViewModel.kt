package com.example.recipecompose.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipecompose.data.RecipeProvider
import com.example.recipecompose.model.Recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class RecipeViewModel : ViewModel() {

    // State lưu query tìm kiếm
    val searchQuery = MutableStateFlow("")

    // Dùng Flow: mỗi khi searchQuery thay đổi → tự động search lại
    @OptIn(ExperimentalCoroutinesApi::class)
    val recipes: StateFlow<List<Recipe>> = searchQuery
        .flatMapLatest { query ->
            flow {
                emit(RecipeProvider.search(query))
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = RecipeProvider.search("")
        )

    // Toggle like cho recipe
    fun toggleLike(recipe: Recipe) {
        // Trong thực tế sẽ update database
        // Ở đây demo đơn giản: update trực tiếp trong list
    }

    fun onSearchQueryChange(query: String) {
        searchQuery.value = query
    }
}
