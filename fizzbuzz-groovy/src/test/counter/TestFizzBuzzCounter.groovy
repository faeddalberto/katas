package test.counter

import main.counter.FizzBuzzCounter

class TestFizzBuzzCounter extends GroovyTestCase {

    FizzBuzzCounter fizzBuzzCounter = new FizzBuzzCounter()

    void test_given3_IsMultipleOf3_shouldReturnTrue() {
        boolean is3MultipleOf3 = 3 % 3 == 0
        assertTrue(is3MultipleOf3)
    }

    void test_given5_IsMultipleOf5_shouldReturnTrue() {
        boolean is5MultipleOf5 = 5 % 5 == 0
        assertTrue(is5MultipleOf5)
    }

    void test_given15_IsMultipleOf3_shouldReturnTrue() {
        boolean is15MultipleOf3 = 15 % 3 == 0
        assertTrue(is15MultipleOf3)
    }

    void test_given15_IsMultipleOf5_shouldReturnTrue() {
        boolean is15MultipleOf15 = 15 % 5 == 0
        assertTrue(is15MultipleOf15)
    }

    void test_given11_IsMultipleOf3_shouldReturnFalse() {
        boolean is11MultipleOf3 = 11 % 3 == 0
        assertFalse(is11MultipleOf3)
    }

    void test_given7_IsMultipleOf5_shouldReturnFalse() {
        boolean is7MultipleOf5 = 7 % 5 == 0
        assertFalse(is7MultipleOf5)
    }

    void test_shouldIterate1to100AndPrintAsExpected() {
        fizzBuzzCounter.iterate()
    }
}
