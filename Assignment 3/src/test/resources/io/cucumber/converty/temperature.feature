Feature: Temperature conversion
  In order to convert temperatures between Fahrenheit and Celsius
  As a user of the Conversions class
  I want to correctly convert temperatures

  Scenario Outline: Valid temperature conversion
    Given I have a temperature of <temp> in <unit>
    When I convert the temperature
    Then the result should be <convertedTemp> in <convertedUnit>

    Examples:
      | temp      | unit | convertedTemp | convertedUnit |
      | 32        | F    | 0             | C             |
      | 0         | C    | 32            | F             |
      | 0.0       | F    | -17.7778      | C             |
      | -40       | F    | -40           | C             |
      | 212.0     | F    | 100           | C             |
      | 100.0     | C    | 212.0         | F             |
      | 2000000.0 | F    | 1111093.3333  | C             |

  Scenario: Temperature conversion with invalid unit
    Given I have a temperature of 1000 in "X"
    When I convert the temperature
    Then I should receive an invalid unit error

  Scenario: Temperature conversion with distance unit
    Given I have a temperature of 1000 in km
    When I convert the temperature
    Then I should receive an invalid unit error

  Scenario: Temperature conversion with NaN
    Given I have a temperature of NaN in F
    When I convert the temperature
    Then I should receive an invalid value error

  Scenario: Temperature conversion with Inf
    Given I have a temperature of Inf in C
    When I convert the temperature
    Then I should receive an invalid value error

  Scenario: Make sure really big values convert
    Given I have a really big temperature
    When I convert the temperature
    Then I should not get an exception

  Scenario: Make sure really big values overflow
    Given I have a really big temperature
    When I convert the temperature
    Then the result should be infinite

  Scenario: Make sure really small values underflow
    Given I have a really small temperature
    When I convert the temperature
    Then the result should be same as converting zero


