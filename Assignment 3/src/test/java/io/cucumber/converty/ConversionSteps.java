package io.cucumber.converty;

import io.cucumber.converty.Conversions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;


public class ConversionSteps {

  private double value;
  private String unit;
  private double convertedValue;
  private Exception exception;

  /////////////////////////////////////////////////
  // Step definitions for temperature conversion //
  /////////////////////////////////////////////////

  @Given("I have a temperature of NaN in F")
  public void i_have_a_temperature_of_na_n_in_f() {
    this.value = Float.NaN;
    this.unit = "F";
  }

  @Given("I have a temperature of {double} in {string}")
  public void i_have_a_temperature_of_in(double temp, String unit) {
    this.value = temp;
    this.unit = unit;
  }

  @Given("I have a temperature of {double} in {unit}")
  public void i_have_a_temperature(double value, String unit) {
    this.value = value;
    this.unit = unit;
  }

  @When("I convert the temperature")
  public void i_convert_the_temperature() {
    try {
      this.convertedValue = Conversions.convertTemperature(value, unit);
    } catch (Exception e) {
      this.exception = e;
    }
  }

  @Then("the result should be {double} in {string}")
  public void the_result_should_be_in(double expected, String expectedUnit) {
    assertEquals(expected, convertedValue, 0.01);
  }

  @Then("the result should be {double} in {unit}")
  public void the_result_should_be(double expected, String expectedUnit) {
    assertEquals(expected, convertedValue, 0.01);
  }

  @Then("I should receive an invalid unit error")
  public void i_should_receive_an_invalid_unit_error() {
    assertNotNull(exception);
    assertTrue(exception instanceof IllegalArgumentException);
  }
  @Then("I should receive an invalid value error")
  public void i_should_receive_an_invalid_value_error() {
    assertNotNull(exception);
    assertTrue(exception instanceof IllegalArgumentException);
  }

  //////////////////////////////////////////////
  // Step definitions for distance conversion //
  //////////////////////////////////////////////

  @Given("I have a distance of {double} in {string}")
  public void i_have_a_distance_of_in(double dist, String unit) {
    this.value = dist;
    this.unit = unit;
  }

  @Given("I have a distance of {double} in {unit}")
  public void i_have_a_distance(double dist, String unit) {
    this.value = dist;
    this.unit = unit;
  }

  @Given("I have a Distance of NaN in {string}")
  public void i_have_a_distance_of_na_n_in(String string) {
    this.value = Float.NaN;
    this.unit = string;
  }

  @Given("I have a distance of {int} in meters")
  public void i_have_a_distance_of_in_meters(Integer dist) {
    this.value = dist;
    this.unit = "m";
  }

  @When("I convert the distance")
  public void i_convert_the_distance() {
    try {
      // System.out.println("converting " + value + " from " + unit);
      this.convertedValue = Conversions.convertDistance(value, unit);
    } catch (Exception e) {
      this.exception = e;
    }
  }

}


