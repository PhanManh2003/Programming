package assignment1

class VehicleManager {
    private val vehicles = mutableListOf<Vehicle>()

    fun addVehicle(vehicle: Vehicle) {
        vehicles.add(vehicle)
        println("Added: ${vehicle.licensePlate}")
    }

    fun displayAll() {
        println("\n---------VEHICLE LIST---------")
        vehicles.forEachIndexed { i, v -> println("#${i+1} ${v.getInfo()}") }
    }

    fun calculateTotalPrice(): Double = vehicles.sumOf { it.calculateTotalPrice() }
}