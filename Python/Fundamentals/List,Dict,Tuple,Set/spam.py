class Apple:

  def __init__(self, apples):

       self.apples = apples

        a1 = Apple(100)

        a2 = Apple(25)

        a3 = Apple(a1.apples % (Apple(10).apples + a2.apples))

print(a3.apples)