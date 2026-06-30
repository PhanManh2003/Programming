package com.example.hiltcrypto.data.repository

import com.example.hiltcrypto.data.model.Cryptocurrency

interface CryptoRepository {
    fun getCryptos(): List<Cryptocurrency>
}