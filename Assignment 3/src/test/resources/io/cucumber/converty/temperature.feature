Feature: Temperature conversion
  In order to convert temperatures between Fahrenheit and Celsius
  As a user of the Conversions class
  I want to correctly convert temperatures

  # Scenario Outline: Valid temperature conversion
  #   Given I have a temperature of <temp> in <unit>
  #   When I convert the temperature
  #   Then the result should be <convertedTemp> in <convertedUnit>

  #   Examples:
  #     | temp | unit | convertedTemp | convertedUnit |
  #     | 32   | F    | 0             | C             |
  #     | 0    | C    | 32            | F             |
  #     | -40  | F    | -40           | C             |

  # Scenario: Temperature conversion with invalid unit
  #   Given I have a temperature of 100 in X
  #   When I convert the temperature
  #   Then I should receive an invalid unit error

  Scenario: Temperature conversion with NaN
    Given I have a temperature of NaN in F
    When I convert the temperature
    Then I should receive an invalid input error
