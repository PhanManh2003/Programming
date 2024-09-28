# test_palindrome.py
import unittest
import palindrome


class TestExercise(unittest.TestCase):
    MESSAGE_FMT = 'Kết quả mong muốn là `{0}`, nhận được `{1}`: `{2}`'

    def _test_all(self, func, cases):  # ( func là 1 parameter đại diện cho hàm )
        for input_, expect in cases:
            output = func(input_)  # The expression func() means "call the function assigned to the parameter func."
            msg = self.MESSAGE_FMT.format(expect, output, input_)  # string.format(a,b,c,...)
            self.assertEqual(output, expect, msg)


class TestPalindrome(TestExercise):  # kế thừa

    def _test_check_palindrome(self):
        cases = [('ana', True),
                 ('Civic', True),
                 ('Python', False),
                 ('', False),
                 ('P', False),
                 ('Able was I ere I saw Elba', True)]
        self._test_all(palindrome.check_palindrome, cases)


if __name__ == '__main__':
    unittest.main(verbosity=2)
# when a testing framework import this file , the value of __name__ won't be __main__ => this block will not be executed
# Ý nghĩa: Tránh việc framework phải chạy bài test này, gây nhiễu dự án
