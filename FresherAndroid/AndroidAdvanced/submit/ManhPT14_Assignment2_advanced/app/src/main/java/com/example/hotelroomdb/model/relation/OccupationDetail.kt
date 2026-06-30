package com.example.hotelroomdb.model.relation

data class OccupationDetail(
    val occupationId: Int,
    val clientName: String,
    val roomNumber: Int,
    val typeName: String,
    val pricePerNight: Double,
    val checkIn: String,
    val checkOut: String,
    val extraExpenses: Double
)