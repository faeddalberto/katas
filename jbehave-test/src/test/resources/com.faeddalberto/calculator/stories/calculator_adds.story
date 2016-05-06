Narrative:
In order to quickly find out the sum of two numbers
As a user
I want to use a calculator to add two numbers

Scenario: Add two numbers

Given a calculator which calculates adds
When I add <number1> and <number2>
Then the sum outcome should be <result>

Examples:
|number1|number2|result|
|10.0|10.0|20.0|
|15.0|18.9|33.9|
|100.0|310.0|410.0|
|150.0|197.9|347.9|