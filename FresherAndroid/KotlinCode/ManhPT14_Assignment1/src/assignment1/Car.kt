package assignment1

class Car(
    licensePlate: String,
    yearOfManufacture: Int,
    price: Double,
    val brand: String,
    val numberOfSeats: Int
) : Vehicle(licensePlate, yearOfManufacture, price) {
    override fun getInfo(): String =
        "[CAR] License: $licensePlate | Brand: $brand | Year: $yearOfManufacture " +
                "| Seats: $numberOfSeats | Price: $$price"
    override fun calculateTotalPrice(): Double = price * 1.10
}