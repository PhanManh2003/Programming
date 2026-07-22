package com.example.facebook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facebook.data.local.entity.UserEntity
import com.example.facebook.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private var generatedOtp: String = ""

    private val _userFound = MutableLiveData<UserEntity?>()
    val userFound: LiveData<UserEntity?> = _userFound

    private val _otpGenerated = MutableLiveData<String>()
    val otpGenerated: LiveData<String> = _otpGenerated

    fun findAccount(email: String) {
        viewModelScope.launch {
            val user = repository.findByEmail(email)
            _userFound.value = user
        }
    }

    fun generateOtp(): String {
        generatedOtp = (100000..999999).random().toString()
        _otpGenerated.value = generatedOtp
        return generatedOtp
    }

    fun verifyOtp(input: String): Boolean = input == generatedOtp

    fun clearUserFound() {
        _userFound.value = null
    }
}
