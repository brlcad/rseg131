Feature: Distance conversion
  In order to convert distances between various units
  As a user of the Conversions class
  I want to correctly convert distances

  Scenario: Distance conversion with valid unit
    Given I have a distance of 100 in meters
    When I convert the distance
    Then the result should be 328.084 in "ft"

  Scenario: Distance conversion with invalid unit
    Given I have a distance of 100 in "X"
    When I convert the distance
    Then I should receive an invalid unit error

  Scenario: Distance conversion with NaN
    Given I have a Distance of NaN in "ft"
    When I convert the distance
    Then I should receive an invalid value error
