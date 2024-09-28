"""Import Car-class file"""  # Must include a guideline docstring


# We can store as many classes in a module as we want.

class Car:
    def __init__(self, make, model, year):
        """Initialize attributes to describe a car."""
        self.make = make
        self.model = model
        self.year = year
        self.odometer_reading = 12  # set default value for an attribute

    def get_name(self):
        """Return a name for the car."""
        real_name = f"{self.year} {self.model} {self.make}"
        return real_name  # đưa giá trị real_name cho hàm get_name

    def read_odometer(self):
        """Print a statement about the car's mileage."""
        print(f"This car has run {self.odometer_reading} miles already.")

    def update_odometer(self, mileage):
        """Update odometer"""
        if mileage >= self.odometer_reading:
            self.odometer_reading = mileage
        else:
            print("\nYou can't roll back an odometer!")

    def increment_odometer(self, miles):
        """Add given amount to the odometer_reading"""
        self.odometer_reading += miles


class ElectricCar(Car):
    """Represent aspects of an electric car based on class Car."""

    def __init__(self, make, model, year):
        """Initialize attributes of the parent class."""
        super().__init__(make, model, year)
        self.battery_size = 97

    def describe_battery(self):
        """Print a statement describe the battery size."""
        print(f"This car has a {self.battery_size}-kWh battery.")
