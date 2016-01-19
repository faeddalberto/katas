import unittest
from main.counter import FizzBuzzCounter


class TestFizzBuzzCounter(unittest.TestCase):

    def test_givenNumber3_isMultipleOf3_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is3multipleof3 = fizzBuzzCounter.ismultipleof(3, 3)
        self.assertEqual(is3multipleof3, True)

    def test_givenNumber5_isMultipleOf5_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is5multipleof5 = fizzBuzzCounter.ismultipleof(5, 5)
        self.assertEqual(is5multipleof5, True)

    def test_givenNumber15_isMultipleOf3_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is15multipleof3 = fizzBuzzCounter.ismultipleof(15, 3)
        self.assertEqual(is15multipleof3, True)

    def test_givenNumber15_isMultipleOf5_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is15multipleof5 = fizzBuzzCounter.ismultipleof(15, 5)
        self.assertEqual(is15multipleof5, True)

    def test_givenNumber11_isMultipleOf3_shouldReturnFalse(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is11multipleof3 = fizzBuzzCounter.ismultipleof(11, 3)
        self.assertEqual(is11multipleof3, False)

    def test_givenNumber23_isMultipleOf5_shouldReturnFalse(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is23multipleof5 = fizzBuzzCounter.ismultipleof(23, 5)
        self.assertEqual(is23multipleof5, False)

    def test_printAndReturnFizz_shouldPrintAndReturnAsExpected(self):
        expected = "fizz"
        fizzBuzzCounter = FizzBuzzCounter()
        fizz = fizzBuzzCounter.printAndReturnFizz()
        self.assertEqual(fizz, expected)

    def test_printAndReturnBuzz_shouldPrintAndReturnAsExpected(self):
        expected = "buzz"
        fizzBuzzCounter = FizzBuzzCounter()
        buzz = fizzBuzzCounter.printAndReturnBuzz()
        self.assertEqual(buzz, expected)

    def test_printAndReturnFizzBuzz_shouldPrintAndReturnAsExpected(self):
        expected = "fizzbuzz"
        fizzBuzzCounter = FizzBuzzCounter()
        fizzBuzz = fizzBuzzCounter.printAndReturnFizzBuzz()
        self.assertEqual(fizzBuzz, expected)

    def test_count1to100_shouldPrintAndReturnAsExpected(self):
        expectedCounter = " 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz " \
                          "fizz 22 23 fizz buzz 26 fizz 28 29 fizzbuzz 31 32 fizz 34 buzz fizz 37 38 fizz buzz " \
                          "41 fizz 43 44 fizzbuzz 46 47 fizz 49 buzz fizz 52 53 fizz buzz 56 fizz 58 59 fizzbuzz " \
                          "61 62 fizz 64 buzz fizz 67 68 fizz buzz 71 fizz 73 74 fizzbuzz 76 77 fizz 79 " \
                          "buzz fizz 82 83 fizz buzz 86 fizz 88 89 fizzbuzz 91 92 fizz 94 buzz fizz 97 98 fizz buzz"
        fizzBuzzCounter = FizzBuzzCounter()
        actualCounter = fizzBuzzCounter.count1to100()
        self.assertEqual(actualCounter, expectedCounter)

