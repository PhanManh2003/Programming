# 1. Create a class
# intro example
class Robot:
    def __init__(self, name, made_in):  # phương thức khởi tạo
        self.name = name
        self.made_in = made_in

# !1 Các biến có tiền số self như này gọi là "attribute( thuộc tính)"
# !2 Có thể đặt self.a = b ( tên a khác tên b vì init chỉ làm nhiệm vụ truyền parameter b vào "biến a")
# !3 Bất kì biến nào có tiền tố là self. đều có sẵn cho mọi method trong class
    # và access được qua mọi thực thể bên ngoài Class ( lí do cho việc gán tham số = biến self.)
    def chao(self):
        print(f'Xin chào, tôi là Robot {self.name}')

    def xuat_xu(self):
        print(f"Tôi đến từ {self.made_in}")


# Khai báo object cụ thể
rb1 = Robot('ANC', 'USA')  # syntax: Instance = Class('value_1', 'value_2',...)
rb2 = Robot('Meta', 'Canada')

rb1.chao()  # method calls: Instance_name.method_name()
rb1.xuat_xu()
rb2.chao()
rb2.xuat_xu()

# Access an attribute of an object:
print(rb1.name)


# 2. Modify attribute values
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


my_car = Car('lamborghini', 'LP700', '2020')  # gán đúng thứ tự như lúc khai bá o attribute ở __init__
my_car_2 = Car('audi', 'A7', '2016')
print(my_car.model)
space = "************************"
space += "\n************************"
print(space)

print(my_car.get_name())  # thêm print vì trong Method get_name chưa có lệnh print
my_car.read_odometer()

# 2.1 Modify attribute value Directly
my_car.odometer_reading = 101  # sửa trực tiếp !!!
my_car.read_odometer()

# 2.2 Modify through a Method ( sửa)
my_car.update_odometer(200)  # truyền 200 cho mileage
my_car.read_odometer()

# 3. Incrementing an Attribute's value by a Method ( tăng, giảm giá trị)
print(my_car_2.get_name())
my_car_2.update_odometer(25_100)
my_car_2.read_odometer()

my_car_2.increment_odometer(125)
my_car_2.read_odometer()
