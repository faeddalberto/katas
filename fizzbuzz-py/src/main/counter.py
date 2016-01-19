class FizzBuzzCounter():

    def ismultipleof(self, i, n):
        if i % n == 0:
            return True
        return False

    def printAndReturnFizz(self):
        fizz = "fizz"
        print fizz
        return fizz

    def printAndReturnBuzz(self):
        buzz = "buzz"
        print buzz
        return buzz

    def printAndReturnFizzBuzz(self):
        fizzbuzz = "fizzbuzz"
        print fizzbuzz
        return fizzbuzz

    def count1to100(self):
        count = ""
        for i in range(1, 101):
            isMultipleOf3 = self.ismultipleof(i, 3)
            isMultipleOf5 = self.ismultipleof(i, 5)

            if isMultipleOf3 & isMultipleOf5:
                count += " " + self.printAndReturnFizzBuzz()
            elif isMultipleOf3:
                count += " " + self.printAndReturnFizz()
            elif isMultipleOf5:
                count += " " + self.printAndReturnBuzz()
            else:
                count += " " + str(i)
                print i
        return count



