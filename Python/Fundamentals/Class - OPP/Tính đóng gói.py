class Foo:
    # Khai báo thuộc tính ở chuẩn private
    __name = "Foo"

    # Khai báo phương thức ở chuẩn private
    def __getName(self):
        print(self.__name) # gọi thành phần trong class

    # khai báo một phương thức public để gọi phương thức private
    def get(self):
        self.__getName()


# gọi thành phần ngoài class
print(Foo().__name)  # 'Foo' object has no attribute '__name'
Foo().__getName()  # 'Foo' object has no attribute '__getName'
Foo().get()  # Foo ( chỉ class đó gọi phương thức public thì dc )


class Bar(Foo):  # class kế thừa gọi phương thức public
    def getNameinFoo(self):
        self.__getName()


# test
Bar().getNameinFoo()  # 'Bar' object has no attribute '_Bar__getName'
