for x in range(1, 21):
    print(x)
# 2
million = list(range(1, 1000000))
print(min(million))
print(max(million))
print(sum(million))

# 3
for y in range(1, 20, 2):
    print(y)
# 4
boi_so_3 = [value_1 for value_1 in range(3, 30, 3)]
print(boi_so_3)

for value_2 in range(3, 30, 3):  # Cach 2
    print(value_2)
# 5
cubes = []
for cube in range(1, 11):
    cubes.append(cube ** 3)
print(cubes)

# 6
car = 'toyota'
print("is car == 'toyota'? I predict True.")
print(car == 'toyota')
print(car == 'audi')
print("\n")

# 7 Điền username và tránh bị lặp tên
current_users = ['Manh', 'Dung', 'An', 'Binh', 'Chi', 'Hoa', 'Phong']
new_users = ['manh', 'thuy', 'Mai']
current_users_lower = ['manh', 'dung', 'an', 'binh', 'chi', 'hoa', 'phong']

for new_user in new_users:
    if new_user.lower() in current_users_lower:
        print("Not valid, set another nickname!")
    else:
        print("Ok")


# 8 Class
class User:
    def __init__(self, first_name, last_name, age, height):
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.height = height
        self.login_attempts = 0

    def describe_user(self):
        """Describe a user through a set of attributes."""
        print(f"\nSummary of {self.first_name}: ")
        print(f"- first_name: {self.first_name}")
        print(f"- last_name: {self.last_name}")
        print(f"- age: {self.age}")
        print(f"- height: {self.height}")

    def greet_user(self):
        """Print the info of a user."""
        hello = f"Hello, {self.first_name} {self.last_name}."
        print(hello)
        return hello

    def increment_login_attempts(self, unit):
        """Add a given number to login_attempts."""
        self.login_attempts += unit

    def read_login_attempts(self):
        """Show login_attempts."""
        print(f"User has login {self.login_attempts} times.")

    def reset_login_attemps(self):
        """Reset login attempts."""
        self.login_attempts = 0

    # Task 1: Showing user's info


user_1 = User('Phan', 'Manh', '20', '170cm')
user_1.greet_user()
user_1.describe_user()

# Task 2: increment
user_1.increment_login_attempts(1)
user_1.read_login_attempts()
user_1.increment_login_attempts(1)
user_1.read_login_attempts()
user_1.increment_login_attempts(1)
user_1.read_login_attempts()
user_1.increment_login_attempts(1)
user_1.read_login_attempts()
# Task 3: reset
user_1.reset_login_attemps()
user_1.read_login_attempts()


# 9
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
        print(f"\nThis car has run {self.odometer_reading} miles already.")

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

    def read_odometer(self):  # Ghi đè hàm read_odometer
        """Electric car don't need a odometer."""
        print("This car doesn't need a odometer!")


my_tesla = ElectricCar('tesla', 'Zeus 1', '2016')
print()  # in 1 line cho kí tự trống dể phân chia 2 bài tập
print(my_tesla.get_name())
my_tesla.describe_battery()
my_tesla.read_odometer()


# 10.
def check(is_number=False):
    print("shit") if is_number else print("ok")


check()
check(is_number=True)

# 11.
x = "fsdasdfgh"


def checking():
    if 'i' in x:
        return False
    return True


if not checking():
    print("SAI")
else:
    print("OK")

