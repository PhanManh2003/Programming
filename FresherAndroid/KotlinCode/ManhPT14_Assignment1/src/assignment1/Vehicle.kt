package assignment1

abstract class Vehicle(
    val licensePlate: String,
    val yearOfManufacture: Int,
    val price: Double
) {
    abstract fun getInfo(): String
    open fun calculateTotalPrice(): Double = price // return price val, open for override enable
}