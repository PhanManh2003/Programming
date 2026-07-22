package com.example.facebook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

import androidx.lifecycle.viewModelScope
import com.example.facebook.data.local.entity.UserEntity
import com.example.facebook.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val allUsers: LiveData<List<UserEntity>> =
        repository.allUsers.asLiveData()

    private val _loginResult = MutableLiveData<UserEntity?>()
    val loginResult: LiveData<UserEntity?> = _loginResult

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = repository.login(email, password)
            if (user != null) {
                _loginResult.value = user
            } else {
                _errorMessage.value = "Email hoặc mật khẩu không đúng"
            }
        }
    }

    fun updatePassword(email: String, newPassword: String) {
        viewModelScope.launch {
            repository.updatePassword(email, newPassword)
        }
    }
}
