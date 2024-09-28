# 3. Tính kế thừa( inheritance): father class & child class
# ta vẫn dùng class Car ở 2.
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


# TODO 1. Add new attributes and methods for Child Class
class ElectricCar(Car):
    """Represent aspects of an electric car based on class Car."""

    def __init__(self, make, model, year):
        """Initialize attributes of the parent class."""
        super().__init__(make, model, year)
        self.battery_size = 97  # muốn thêm thuộc tính cho lớp con thì phải có hàm super()

    def describe_battery(self):
        """Print a statement describe the battery size."""
        print(f"This car has a {self.battery_size}-kWh battery.")


my_tesla = ElectricCar('tesla', 'Zeus 1', '2016')
print()  # in 1 line cho kí tự trống dể phân chia 2 bài tập
print(my_tesla.get_name())
my_tesla.describe_battery()


# TODO 2. Override Methods from Parent Class that doesn't fit with Child Class
class ElectricCar(Car):
    """Represent aspects of an electric car based on class Car."""

    # --snip--

    # def read_odometer(self):  # Ghi đè hàm read_odometer
    #     """Electric car don't need a odometer."""
    #     print("This car doesn't need a odometer!")
    #  bây giờ gọi hàm này thì code bên trong đã bị sửa.

# TODO 3. Making an attribute become an sub-instance ( an sub-class) to simplify the original class.

# ta sẽ xét class ElectricCar với biến battery:
# Trong trường hợp biến battery có quá nhiều thuộc tính,
# ta có thể tạo 1 Class Battery với các thuộc tính và method cụ thể
# Sau khi tạo xong class Battery, ở trong class ElectricCar ta tạo biến battery như sau: self.battery = Battery()
# Sau đó gọi hàm ở bên ngoài qua object cụ thể , vd:
# vinfast = ElectricCar('Vinfast', 'VF5', '2030')
# vinfast.battery.describe_battery()
