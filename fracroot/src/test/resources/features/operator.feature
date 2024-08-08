@tag
Feature: Operator

  Scenario: do the operation on two integer numbers
    Given Two integer input values, 4 and 1
    When I do the operation on the two values
    Then I expect the result 2

  Scenario: do the operation on two integer numbers
    Given Two integer input values, 36 and 4
    When I do the operation on the two values
    Then I expect the result 3

  Scenario: do the operation on two integer numbers
    Given Two integer input values, 50 and 5
    When I do the operation on the two values
    Then I expect the result 3.1622

  Scenario: do the operation on two integer numbers
    Given Two integer input values, 0 and 1
    When I do the operation on the two values
    Then I expect the result 0

  Scenario: Division by zero
    Given Two integer input values, 4 and 0
    When I do the operation on the two values
    Then I expect an arithmetic error throws


  Scenario: Do the operation on two double numbers
    Given Two double input values, 4.0 and 1.0
    When I do the operation on the two values
    Then I expect an illegal argument error throws


  Scenario: Do the operation on invalid inputs
    Given Two double input values, 4.5 and 1
    When I do the operation on the two values
    Then I expect an illegal argument error throws

  Scenario: Do the operation on invalid inputs
    Given Two double input values, 4 and 1.5
    When I do the operation on the two values
    Then I expect an illegal argument error throws

  Scenario: Do the operation on invalid inputs
    Given Two double input values, 4.5 and 1.5
    When I do the operation on the two values
    Then I expect an illegal argument error throws
