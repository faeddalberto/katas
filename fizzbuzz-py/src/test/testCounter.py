import unittest
from main.counter import FizzBuzzCounter


class TestFizzBuzzCounter(unittest.TestCase):

    def test_givenNumber3_isMultipleOf3_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is3multipleof3 = fizzBuzzCounter.isItMultipleOfN(3, 3)
        self.assertEqual(is3multipleof3, True)

    def test_givenNumber5_isMultipleOf5_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is5multipleof5 = fizzBuzzCounter.isItMultipleOfN(5, 5)
        self.assertEqual(is5multipleof5, True)

    def test_givenNumber15_isMultipleOf3_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is15multipleof3 = fizzBuzzCounter.isItMultipleOfN(15, 3)
        self.assertEqual(is15multipleof3, True)

    def test_givenNumber15_isMultipleOf5_shouldReturnTrue(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is15multipleof5 = fizzBuzzCounter.isItMultipleOfN(15, 5)
        self.assertEqual(is15multipleof5, True)

    def test_givenNumber11_isMultipleOf3_shouldReturnFalse(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is11multipleof3 = fizzBuzzCounter.isItMultipleOfN(11, 3)
        self.assertEqual(is11multipleof3, False)

    def test_givenNumber23_isMultipleOf5_shouldReturnFalse(self):
        fizzBuzzCounter = FizzBuzzCounter()
        is23multipleof5 = fizzBuzzCounter.isItMultipleOfN(23, 5)
        self.assertEqual(is23multipleof5, False)

    def test_printAndReturnFizz_shouldPrintAndReturnAsExpected(self):
        expected = "fizz"
        fizzBuzzCounter = FizzBuzzCounter()
        fizz = fizzBuzzCounter.getFizz()
        self.assertEqual(fizz, expected)

    def test_printAndReturnBuzz_shouldPrintAndReturnAsExpected(self):
        expected = "buzz"
        fizzBuzzCounter = FizzBuzzCounter()
        buzz = fizzBuzzCounter.getBuzz()
        self.assertEqual(buzz, expected)

    def test_printAndReturnFizzBuzz_shouldPrintAndReturnAsExpected(self):
        expected = "fizzbuzz"
        fizzBuzzCounter = FizzBuzzCounter()
        fizzBuzz = fizzBuzzCounter.getFizzBuzz()
        self.assertEqual(fizzBuzz, expected)
