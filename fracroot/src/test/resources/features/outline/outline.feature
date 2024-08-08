@tag
Feature: Operator

  Scenario Outline: Perform the operation on two numbers
    Given Two input values, <val1> and <val2>
    When I do the operation on the two values
    Then I expect the result <expected>

    Examples:
      | val1 | val2 | expected |
      | 4    | 1    | 2              |
      | 36   | 4    | 3              |
      | 50   | 5    | 3.1622         |
      | 0    | 1    | 0              |
      | -4   | -1   | 2              |

  Scenario Outline: Handle division by zero
    Given Two input values, <val1> and <val2>
    When I do the operation on the two values
    Then I expect an arithmetic error throws

    Examples:
      | val1 | val2 |
      | 4    | 0    |

  Scenario Outline: Handle invalid double inputs
    Given Two input values, <val1> and <val2>
    When I do the operation on the two values
    Then I expect an illegal argument error throws

    Examples:
      | val1 | val2 |
      | 4.0  | 1.0  |
      | 4.5  | 1    |
      | 4    | 1.5  |
      | 4.5  | 1.5  |
      | -4.5 | 1    |

  Scenario Outline: Handle negative integer inputs
    Given Two input values, <val1> and <val2>
    When I do the operation on the two values
    Then I expect a negative argument error throws

    Examples:
      | val1 | val2 |
      | -4   | 1    |
      | 4    | -1   |

  Scenario Outline: Handle negative double inputs
    Given Two input values, <val1> and <val2>
    When I do the operation on the two values
    Then I expect an illegal argument error throws

    Examples:
      | val1 | val2 |
      | -4.5 | 1    |
