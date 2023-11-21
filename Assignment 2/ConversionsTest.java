/**
 * Christopher Sean Morrison
 * RSEG131 Assignment 2
 *
 * This file contains unit tests for the Conversions class.
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ConversionsTest {

  private Conversions conversions;
  private double tolerance = 0.0001;

  @BeforeAll
  static void setupAll() {
    /* called once before all the tests run, nothing to do yet. */
  }

  @AfterAll
  static void tearDownAll() {
    /* called once after all the tests run, nothing to do yet. */
  }

  @BeforeEach
  void setup() {
    /* called once before each test runs */

    /* start with a fresh class */
    conversions = new Conversions();
  }

  @AfterEach
  void tearDown() {
    /* called after each test runs */

    /* let it go, let it go.. */
    conversions = null;
  }


  /*****************************
   * Distance Conversion Tests *
   *****************************/

  /**
   * Test conversion from miles to kilometers.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert Mile to Kilometers - Positive Test")
  void testMilesToKilometers() {
    double distance = 1.0; // 1 mile
    double expected = 1.60934; // expected kilometers equivalent
    double actual = Conversions.convertDistance(distance, "mi");
    assertEquals(expected, actual, tolerance, "Miles to Kilometers conversion did not produce expected result.");
  }

  /**
   * Test inverse conversion of kilometer to miles.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 1 Kilometer to Miles - Positive Test")
  void testKilometersToMiles() {
    assertEquals(0.621371, Conversions.convertDistance(1.0, "km"), tolerance, "1 kilometer should be 0.621371 miles.");
  }

  /**
   * Test conversion of foot to meters.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 1 Foot to Meters - Positive Test")
  void testFeetToMeters() {
    assertEquals(0.3048, Conversions.convertDistance(1.0, "ft"), tolerance, "1 foot should be 0.3048 meters.");
  }

  /**
   * Test inverse conversion of meter to feet.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 1 Meter to Feet - Positive Test")
  void testMetersToFeet() {
    assertEquals(3.28084, Conversions.convertDistance(1.0, "m"), tolerance, "1 meter should be 3.28084 feet.");
  }

  /**
   * Test conversion of inch to centimeters.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 1 inch to centimeters - Positive Test")
  void testInchToCentimeters() {
    assertEquals(2.54, Conversions.convertDistance(1.0, "in"), tolerance, "1 inch should be 2.54 centimeters.");
  }

  /**
   * Test inverse conversion of centimeter to inches.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 1 centimeter to inches - Positive Test")
  void testCentimetersToInches() {
    assertEquals(0.393701, Conversions.convertDistance(1.0, "cm"), tolerance, "1 centimeter should be 0.393701 inches.");
  }

  // Equivalence class spot-test (negative values)

  /**
   * Make sure a negative value convert.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert negative distance to miles - Smoke Test")
  void testNegativeDistance() {
    assertEquals(-0.621371, Conversions.convertDistance(-1.0, "km"), tolerance, "1 kilometer should be 0.621371 miles.");
  }

  /**
   * Make sure additional units work (decimeters)
   * Success if return value is precise expected value.
   */
  @Test
  @DisplayName("Convert decimeters to meters - Smoke Test")
  void testDecimeterDistance() {
    // expecting exact match
    assertEquals(1234.5, Conversions.convertDistance(12345, "dm"), "12345 decimeters should be 1234.5 meters.");
  }

  /**
   * Make sure additional units work (yards)
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert yards to meters - Smoke Test")
  void testYardDistance() {
    assertEquals(-11288.268, Conversions.convertDistance(-12345, "yd"), tolerance, "-12345 yards should be -11288.268 meters.");
  }

  // Negative Cases

  /**
   * Make sure invalid units don't convert.
   * Success if exception is thrown.
   */
  @Test
  @DisplayName("Invalid distance unit throws - Negative Test")
  void testInvalidDistanceUnit() {
    assertThrows(IllegalArgumentException.class, () -> Conversions.convertDistance(10, "xyz"), "Invalid distance unit should throw an exception.");
  }

  /**
   * Make sure NaN values don't convert.
   * Success if exception is thrown.
   */
  @Test
  @DisplayName("NaN value distance throws - Negative Test")
  void testNanDistanceUnit() {
    assertThrows(IllegalArgumentException.class, () -> Conversions.convertDistance(Double.NaN, "ft"), "NaN values should throw an exception.");
  }

  /**
   * Make sure Inf values don't convert.
   * Success if exception is thrown.
   */
  @Test
  @DisplayName("Inf value distance throws - Negative Test")
  void testInfDistanceUnit() {
    assertThrows(IllegalArgumentException.class, () -> Conversions.convertDistance(Double.NEGATIVE_INFINITY, "cm"), "Inf values should throw an exception.");
  }

  // Edge case spot-testing

  /**
   * Make sure zero results in zero.
   * Success if zero.
   */
  @Test
  @DisplayName("Convert 0 km to mi - Edge Test")
  void testZeroDistanceKtoM() {
    /* not within tol, should be exact. */
    assertEquals(0.0, Conversions.convertDistance(0.0, "km"), "0 kilometers should be exactly 0 miles.");
  }

  /**
   * Make sure zero results in zero.
   * Success if zero.
   */
  @Test
  @DisplayName("Convert 0 mi to km - Edge Test")
  void testZeroDistanceMtoK() {
    /* not within tol, should be exact. */
    assertEquals(0.0, Conversions.convertDistance(0.0, "mi"), "0 miles should be exactly 0 kilometers.");
  }

  /**
   * Make sure big values convert.
   * Success if an exception isn't thrown.  Assuming we get a valid value for now.
   */
  @Test
  @DisplayName("Convert very large value - Edge Test")
  void testExtremelyLargeDistance() {
    assertDoesNotThrow(() -> Conversions.convertDistance(Double.MAX_VALUE, "mi"), "Conversion of extremely large distance should not throw.");
  }

  /**
   * Test overflow.
   * Success if return value is Infinity.
   */
  @Test
  @DisplayName("Overflow distance - Edge Test")
  void testOverflowDistanceUnit() {
    // expecting exact match
    assertEquals(Double.POSITIVE_INFINITY, Conversions.convertDistance(Double.MAX_VALUE, "mi"), "Converting max mile to kilometer should overflow and result in Infinity.");
  }

  /**
   * Test underflow.
   * Success if return value is zero.
   */
  @Test
  @DisplayName("Underflow distance - Edge Test")
  void testUnderflowDistanceUnit() {
    // expecting exact match
    assertEquals(0, Conversions.convertDistance(Double.MIN_VALUE, "in"), "Converting min inch to meter should result in zero.");
  }

  /********************************
   * Temperature Conversion Tests *
   ********************************/

  /**
   * Test conversion from Fahrenheit to Celsius.
   * Success if return value is precisely expected value.
   */
  @Test
  @DisplayName("Convert Fahrenheit to Celsius - Positive Test")
  void testFahrenheit212ToCelsius() {
    /* using vars for this first temperature test here so it's clear
     * what assertEquals() is expecting.  subsequent tests are terse.
     */
    double temp = 212.0; // boiling point of water
    double expected = 100.0; // expected Celsius equivalent
    double actual = Conversions.convertTemperature(temp, "F");

    // expecting exact match
    assertEquals(expected, actual, "Fahrenheit to Celsius conversion did not produce expected result.");
  }

  /**
   * Test conversion from Celsius to Fahrenheit.
   * Success if return value is precisely expected value.
   */
  @Test
  @DisplayName("Convert Celsius to Fahrenheit - Positive Test")
  void testCelsius100ToFahrenheit() {
    // expecting exact match
    assertEquals(212, Conversions.convertTemperature(100, "C"), "Celsius to Fahrenheit conversion did not produce expected result.");
  }

  // Negative Cases

  /**
   * Make sure invalid units don't convert.
   * Success if exception is thrown.
   */
  @Test
  @DisplayName("Invalid temperature unit throws - Negative Test")
  void testInvalidTemperatureUnit() {
    assertThrows(IllegalArgumentException.class, () -> Conversions.convertTemperature(1000, "X"), "Invalid temperature unit should throw an exception.");
  }

  /**
   * Make sure NaN values don't convert.
   * Success if exception is thrown.
   */
  @Test
  @DisplayName("NaN value temperature throws - Negative Test")
  void testNanTemperatureUnit() {
    assertThrows(IllegalArgumentException.class, () -> Conversions.convertTemperature(Double.NaN, "F"), "NaN values should throw an exception.");
  }

  /**
   * Make sure Inf values don't convert.
   * Success if exception is thrown.
   */
  @Test
  @DisplayName("Inf value temperature throws - Negative Test")
  void testInfTemperatureUnit() {
    assertThrows(IllegalArgumentException.class, () -> Conversions.convertTemperature(Double.POSITIVE_INFINITY, "C"), "Inf values should throw an exception.");
  }

  // Edge case spot-testing

  /**
   * Test conversion of 32F
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 32F to C - Edge Test")
  void testFahrenheit32ToCelsius() {
    assertEquals(0.0, Conversions.convertTemperature(32.0, "F"), tolerance, "32F should be 0C.");
  }

  /**
   * Test conversion of 32C
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 32C to F - Edge Test")
  void testCelsius0ToFahrenheit() {
    assertEquals(32.0, Conversions.convertTemperature(0.0, "C"), tolerance, "0C should be 32F.");
  }

  /**
   * Test conversion of -40C
   * Success if return value is precisely expected value.
   */
  @Test
  @DisplayName("Convert -40C to F - Edge Test")
  void testCelsius40ToFarenheit() {
    // expecting exact match
    assertEquals(-40, Conversions.convertTemperature(-40.0, "C"), "-40C should be -40F.");
  }

  /**
   * Test conversion of 0F
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert 0F to C - Edge Test")
  void testFarenheight0ToCelsius() {
    assertEquals(-17.7778, Conversions.convertTemperature(0.0, "F"), tolerance, "0F should be -17.7778C.");
  }

  /**
   * Test that large values convert.
   * Success if return value is within tolerance of expected value.
   */
  @Test
  @DisplayName("Convert large temperature - Edge Test")
  void testLargeTemperatureConversion() {
    assertEquals(1111093.3333, Conversions.convertTemperature(2000000.0, "F"), tolerance, "2000000 F should convert to 1111093.3333C.");
  }

  /**
   * Test that really large values convert.
   * Success if an exception isn't thrown.  Assuming we get a valid value for now.
   */
  @Test
  @DisplayName("Convert max value temperature - Edge Test")
  void testExtremelyLargeTemperature() {
    assertDoesNotThrow(() -> Conversions.convertTemperature(Double.MAX_VALUE, "F"), "Conversion of extremely large temperature should not throw.");
  }

  /**
   * Test overflow.
   * Success if return value is Infinity.
   */
  @Test
  @DisplayName("Overflow temperature - Edge Test")
  void testOverflowTemperatureUnit() {
    // expecting exact match
    assertEquals(Double.POSITIVE_INFINITY, Conversions.convertTemperature(Double.MAX_VALUE, "C"), "Converting max C to F should overflow and result in Infinity.");
  }

  /**
   * Test underflow.
   * Success if return value is same as zero conversion.
   */
  @Test
  @DisplayName("Underflow temperature - Edge Test")
  void testUnderflowTemperatureUnit() {
    // expecting exact match
    assertEquals(Conversions.convertTemperature(0, "F"), Conversions.convertTemperature(Double.MIN_VALUE, "F"), "Converting min F to C should result in same as zero F to C.");
  }

}


