package com.fpt.mvvmlogindemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginResult = MutableLiveData<String>()

    fun onLoginClicked() {
        val currentEmail = email.value
        val currentPassword = password.value

        if (currentEmail.isNullOrEmpty() || currentPassword.isNullOrEmpty()) {
            loginResult.value = "Please input email or password!"
            return
        }

        //Repository -> Login()
        if (currentEmail == "admin@fpt.com" && currentPassword == "123456") {
            loginResult.value = "Login success!"
        } else {
            loginResult.value = "Incorrect email or password!"
        }
    }

}