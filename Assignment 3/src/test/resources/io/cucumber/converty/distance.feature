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
      | 0.621371 | km   | 1             | mi            |

  Scenario: Distance conversion with invalid unit
    Given I have a distance of 100 in "X"
    When I convert the distance
    Then I should receive an invalid unit error

  Scenario: Distance conversion with NaN
    Given I have a Distance of NaN in "ft"
    When I convert the distance
    Then I should receive an invalid value error
