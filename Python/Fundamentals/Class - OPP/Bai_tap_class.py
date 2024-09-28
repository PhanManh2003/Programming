from random import randint

repeat = True
while repeat:
    print(f"You rolled {randint(1, 6)}")
    print("Do you want to roll again?")
    repeat = ("y" or "yes") in input().lower()


# 2
class Die:
    def __init__(self):
        self.sides = 6

    def roll(self):
        print(f"\nYou roll {randint(1, self.sides)}")


check = Die()
check.roll()



