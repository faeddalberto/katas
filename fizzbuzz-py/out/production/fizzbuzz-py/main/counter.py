import sys

class FizzBuzzCounter:

    def isItMultipleOfN(self, it, n):
        return it % n == 0

    def getFizz(self):
        return "fizz"

    def getBuzz(self):
        return "buzz"

    def getFizzBuzz(self):
        return "fizzbuzz"

    def count1to100(self):
        msg = ""
        for it in range(1, 101):
            isMultipleOf3 = self.isItMultipleOfN(it, 3)
            isMultipleOf5 = self.isItMultipleOfN(it, 5)

            if isMultipleOf3 & isMultipleOf5:
                msg = self.getFizzBuzz()
            elif isMultipleOf3:
                msg = self.getFizz()
            elif isMultipleOf5:
                msg = self.getBuzz()
            else:
                msg = str(it)

            print(msg)



counter = FizzBuzzCounter()
counter.count1to100()