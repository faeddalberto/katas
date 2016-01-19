package main.counter

class FizzBuzzCounter {

    static void main(String... args) {
        FizzBuzzCounter fizzBuzzCounter = new FizzBuzzCounter()
        fizzBuzzCounter.iterate()
    }

    void iterate() {
        1.upto(100, process)
    }

    def process = {
        boolean multipleOf3 = isMultipleOf(it, 3)
        boolean multipleOf5 = isMultipleOf(it, 5)
        if (multipleOf3 && multipleOf5) {
            printFizzBuzz()
        } else if (multipleOf3) {
            printFizz()
        } else if (multipleOf5) {
            printBuzz()
        } else {
            println(it)
        }
    }

    boolean isMultipleOf(int i, int n) {
        return i % n == 0
    }

    String printFizzBuzz() {
        String fizzbuzz = "fizzbuzz"
        println(fizzbuzz);
        return fizzbuzz
    }

    String printFizz() {
        String fizz = "fizz"
        println(fizz);
        return fizz
    }

    String printBuzz() {
        String buzz = "buzz"
        println(buzz);
        return buzz
    }
}
