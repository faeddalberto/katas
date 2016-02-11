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
        boolean multipleOf3 = it % 3 == 0
        boolean multipleOf5 = it % 5 == 0
        if (multipleOf3 && multipleOf5) {
            println "fizzbuzz"
        } else if (multipleOf3) {
            println "fizz"
        } else if (multipleOf5) {
            println "buzz"
        } else {
            println it
        }
    }
}
