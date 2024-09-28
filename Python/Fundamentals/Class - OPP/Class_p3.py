# A. IMPORTING CLASSES
# 1. import a class
from car import Car, ElectricCar

my_new_car_1 = Car('bugati', 'veyron', '2013')  # import xong thì không thụt lề câu lệnh
print(my_new_car_1.get_name())
my_new_car_1.odometer_reading = 1230
my_new_car_1.read_odometer()
my_new_car_2 = ElectricCar('vinfast', 'A8', '2017')
my_new_car_2.describe_battery()
print()

# 2. Import an entire Module ( not contained specific classes)
import car

my_new_car_3 = car.ElectricCar('audi', 'Q7', '2010')  # !nên làm cách này để hiểu rõ File và Class đang sử dụng
print(my_new_car_3.get_name())
my_new_car_3.odometer_reading = 2400
my_new_car_3.read_odometer()
my_new_car_3.describe_battery()

# 3. Import all functions from a Module
from car import *  # ko nên làm theo cách này vì khó theo dõi code và dễ trùng tên với Class trong module trong khi code

print()
my_new_car_4 = Car('yamaha', 'U77', '2009')
print(my_new_car_4.get_name())

# 4. Import a Module into another Module ( stop 1 file from becoming too big & storing too many unrelated classes)
# Ví dụ: Lưu trữ lớp Car trong  module car.py và lưu lớp ElectricCar , Battery trong 1 module riêng tên electric_car.py

# Trong file chạy tên my_car.py ta viết:
# from car import Car:
# from electric_car import ElectricCar
