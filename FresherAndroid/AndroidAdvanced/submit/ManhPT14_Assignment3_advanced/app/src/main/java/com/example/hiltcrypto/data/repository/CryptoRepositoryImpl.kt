package com.example.hiltcrypto.data.repository

import com.example.hiltcrypto.data.model.Cryptocurrency
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor() : CryptoRepository {

    override fun getCryptos(): List<Cryptocurrency> {
        return listOf(
            Cryptocurrency("Bitcoin",  "BTC", 65000.0, +2.5),
            Cryptocurrency("Ethereum", "ETH",  3200.0, -1.2),
            Cryptocurrency("Solana",   "SOL",   150.0, +5.1),
            Cryptocurrency("BNB",      "BNB",   380.0, +0.8),
            Cryptocurrency("Cardano",  "ADA",     0.6, -3.4)
        )
    }
}