Feature: Distance conversion
  In order to convert distances between various units
  As a user of the Conversions class
  I want to correctly convert distances

  Scenario: Distance conversion with valid unit
    Given I have a distance of 100 in meters
    When I convert the distance
    Then the result should be 328.084 in "ft"

  Scenario Outline: Valid distance conversion
    Given I have a distance of <dist> in <unit>
    When I convert the distance
    Then the result should be <convertedDist> in <convertedUnit>

    Examples:
      | dist     | unit | convertedDist | convertedUnit |
      | 1        | mi   | 1.60934       | km            |
      | 1.0      | km   | 0.621371      | mi            |
      | 1.0      | ft   | 0.3048        | m             |
      | 1.0      | m    | 3.28084       | ft            |
      | 1.0      | in   | 2.54          | cm            |
      | 1.0      | cm   | 0.393701      | in            |
      | -1.0     | km   | -0.621371     | mi            |
      | 12345    | dm   | 1234.5        | m             |
      | -12345   | yd   | -11288.268    | m             |

  Scenario: Distance conversion with invalid unit
    Given I have a distance of 100 in "X"
    When I convert the distance
    Then I should receive an invalid unit error

  Scenario: Distance conversion with NaN
    Given I have a Distance of NaN in "ft"
    When I convert the distance
    Then I should receive an invalid value error
