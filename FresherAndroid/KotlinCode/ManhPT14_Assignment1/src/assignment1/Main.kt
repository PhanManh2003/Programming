package assignment1

fun main() {
    val manager = VehicleManager()

    manager.addVehicle(Car("51A-123.45", 2022, 25000.0, "Toyota", 5))
    manager.addVehicle(Car("30H-123.45", 2023, 45000.0, "Honda", 7))
    manager.addVehicle(Motorcycle("29B-222.33", 2021, 3000.0, 150, "Sport"))
    manager.addVehicle(Motorcycle("51F-333.44", 2020, 1500.0, 110, "Normal"))

    manager.displayAll()
    println("\nTotal Price (with fees): ${"%.2f".format(manager.calculateTotalPrice())}")
}