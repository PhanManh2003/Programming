import unittest
import equation


class TestEquation(unittest.TestCase):  # kế thừa lớp TestCase của module unittest

    def test_root_finder(self):
        # *arg : truyền tuple arg vào hàm root_finder thế cho a,b
        args = (10, 10)
        self.assertEqual(equation.root_finder(*args), -1)
        args = (0, 0)
        self.assertEqual(equation.root_finder(*args), "ALL")
        args = (0, 10)
        self.assertEqual(equation.root_finder(*args), "NONE")


if __name__ == '__main__':
    unittest.main(verbosity=2)
# Tức là với chiêu này ta có thể “khóa” 1 đoạn code trong file chính lại khi nó được import bởi một file khác.
# Đoạn code bị khóa đó chỉ chạy khi file chính được chạy trực tiếp


# __name__ là một biến đặc biệt. Nếu biến này nằm trong một file python bất kỳ.
# Giả dụ ta có file daynhauhoc.py, thì khi ta chạy
#
# python daynhauhoc.py
# __name__ sẽ có giá trị __main__


