package test.counter

import main.counter.FizzBuzzCounter

class TestFizzBuzzCounter extends GroovyTestCase {

    FizzBuzzCounter fizzBuzzCounter = new FizzBuzzCounter()

    void test_given3_IsMultipleOf3_shouldReturnTrue() {
        boolean is3MultipleOf3 = fizzBuzzCounter.isMultipleOf(3, 3)
        assertTrue(is3MultipleOf3)
    }

    void test_given5_IsMultipleOf5_shouldReturnTrue() {
        boolean is5MultipleOf5 = fizzBuzzCounter.isMultipleOf(5, 5)
        assertTrue(is5MultipleOf5)
    }

    void test_given15_IsMultipleOf3_shouldReturnTrue() {
        boolean is15MultipleOf3 = fizzBuzzCounter.isMultipleOf(15, 3)
        assertTrue(is15MultipleOf3)
    }

    void test_given15_IsMultipleOf5_shouldReturnTrue() {
        boolean is15MultipleOf15 = fizzBuzzCounter.isMultipleOf(15, 5)
        assertTrue(is15MultipleOf15)
    }

    void test_given11_IsMultipleOf3_shouldReturnFalse() {
        boolean is11MultipleOf3 = fizzBuzzCounter.isMultipleOf(11, 3)
        assertFalse(is11MultipleOf3)
    }

    void test_given7_IsMultipleOf5_shouldReturnFalse() {
        boolean is7MultipleOf5 = fizzBuzzCounter.isMultipleOf(7, 5)
        assertFalse(is7MultipleOf5)
    }

    void test_shouldPrintAndReturnFizzBuzz() {
        String expected = "fizzbuzz";
        String fizzbuzz = fizzBuzzCounter.printFizzBuzz()
        assertEquals(expected, fizzbuzz)
    }

    void test_shouldPrintAndReturnFizz() {
        String expected = "fizz";
        String fizz = fizzBuzzCounter.printFizz()
        assertEquals(expected, fizz)
    }

    void test_shouldPrintAndReturnBuzz() {
        String expected = "buzz";
        String buzz = fizzBuzzCounter.printBuzz()
        assertEquals(expected, buzz)
    }

    void test_shouldIterate1to100AndPrintAsExpected() {
        fizzBuzzCounter.iterate()
    }
}
