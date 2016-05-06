Narrative:
In order to quickly find out the difference between two numbers
As a user
I want to use a calculator to substract two numbers

Scenario: Substract two numbers

Given a calculator which calculates subs
When I substract <number1> and <number2>
Then the sub outcome should be <result>

Examples:
|number1|number2|result|
|10.0|10.0|0.0|
|15|18.9|-3.8999999999999986|
|310.0|100.0|210.0|
|198|197.9|0.09999999999999432|