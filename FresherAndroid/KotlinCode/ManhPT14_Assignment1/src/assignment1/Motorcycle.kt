package assignment1

class Motorcycle( licensePlate: String,
                  yearOfManufacture: Int,
                  price: Double,
                  val engineCapacity: Int,
                  val motorcycleType: String) :
Vehicle(licensePlate, yearOfManufacture, price){
    override fun getInfo(): String =
        "[MOTORCYCLE] License: $licensePlate | Type: $motorcycleType | Year: $yearOfManufacture" +
                " | Engine: ${engineCapacity}cc | Price: $$price"

    override fun calculateTotalPrice(): Double = price * 1.05
}