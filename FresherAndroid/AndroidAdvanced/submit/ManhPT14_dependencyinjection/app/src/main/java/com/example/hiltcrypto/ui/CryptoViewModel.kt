package com.example.hiltcrypto.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltcrypto.data.model.Cryptocurrency
import com.example.hiltcrypto.data.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
// @HiltViewModel:
class CryptoViewModel @Inject constructor(
    private val repository: CryptoRepository

) : ViewModel() {

    private val _cryptos = MutableLiveData<List<Cryptocurrency>>()
    val cryptos: LiveData<List<Cryptocurrency>> = _cryptos

    init {
        loadCryptos()
    }

    private fun loadCryptos() {
        _cryptos.value = repository.getCryptos()
    }
}