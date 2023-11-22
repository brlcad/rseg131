/**
 * Christopher Sean Morrison
 * RSEG131 Assignment 3
 *
 * This file contains a Conversions class for converting units.
 */

package io.cucumber.converty;

import java.util.HashMap;
import java.util.Map;

public class Conversions {

  private static final Map<String, Double> distances;
  static {
    /* only need mi, km, ft, m, in, and cm, but adding more just for fun */
    distances = new HashMap<>();
    distances.put("mi", 1609.344);
    distances.put("yd", 0.9144);
    distances.put("ft", 0.3048);
    distances.put("in", 0.0254);
    distances.put("km", 1000.0);
    distances.put( "m", 1.0);
    distances.put("dm", 0.1);
    distances.put("cm", 0.01);
    distances.put("mm", 0.001);
    distances.put("m_mi", 1.0 / distances.get("mi"));
    distances.put("m_yd", 1.0 / distances.get("yd"));
    distances.put("m_ft", 1.0 / distances.get("ft"));
    distances.put("m_in", 1.0 / distances.get("in"));
    distances.put("m_km", 1.0 / distances.get("km"));
    distances.put( "m_m", 1.0 / distances.get( "m"));
    distances.put("m_dm", 1.0 / distances.get("dm"));
    distances.put("m_cm", 1.0 / distances.get("cm"));
    distances.put("m_mm", 1.0 / distances.get("mm"));
  }


  /**
   * define NaN and Inf double values as invalid
   */
  protected static void validateValue(double val) throws IllegalArgumentException {
    if (Double.isNaN(val) || Double.isInfinite(val)) {
      throw new IllegalArgumentException("Invalid input: " + val);
    }
  }

  /**
   * NOTE: this function could be public, but using protected for
   * assignment purposes, which calls for specific mapped pairs.
   */
  protected static double convertDistanceFromTo(double dist, String fromUnit, String toUnit) throws IllegalArgumentException {
    fromUnit = fromUnit.toLowerCase();
    toUnit = toUnit.toLowerCase();

    // System.out.println("converting from " + fromUnit + " to " + toUnit);

    Double fromFactor = distances.get(fromUnit);
    Double toFactor = distances.get("m_" + toUnit);

    validateValue(dist);

    if (fromFactor == null || toFactor == null) {
      throw new IllegalArgumentException("Unsupported unit \"" + fromUnit + "\" to \"" + toUnit + "\" for distance conversion.");
    }

    return fromFactor * dist * toFactor;
  }


  public static double convertDistance(double dist, String unit) {
    String from = unit.toLowerCase();
    String to = "m";

    // System.out.println("converting distance " + dist + " from [" + from + "]");

    if (from.equals("mi")) {
      to = "km";
    } else if (from.equals("km")) {
      to = "mi";
    } else if (from.equals("ft")) {
      to = "m";
    } else if (from.equals("m")) {
      to = "ft";
    } else if (from.equals("in")) {
      to = "cm";
    } else if (from.equals("cm")) {
      to = "in";
    }

    // System.out.println("converting distance to " + to);

    return convertDistanceFromTo(dist, from, to);
  }


  protected static double fahrenheitToCelsius(double F) {
    return (F - 32.0) * 5.0 / 9.0;
  }


  protected static double celsiusToFahrenheit(double C) {
    return (C * 9.0 / 5.0) + 32.0;
  }


  public static double convertTemperature(double temp, String unit) throws IllegalArgumentException {
    char from = unit.toUpperCase().charAt(0);

    validateValue(temp);

    if (from == 'F') {
      return fahrenheitToCelsius(temp);
    } else if (from == 'C') {
      return celsiusToFahrenheit(temp);
    }
    throw new IllegalArgumentException("Unsupported unit \"" + unit + "\" for temperature conversion.");
  }


  public static void main(String[] args) {
    // Temperature conversion example
    double temp = 100;
    System.out.println(temp + " F is " + convertTemperature(temp, "F") + " C");

    // Distance conversion example
    double miles = 5;
    System.out.println(miles + " miles is " + convertDistance(miles, "mi") + " kilometers");
    System.out.println(miles + " miles is " + convertDistanceFromTo(miles, "mi", "in") + " inches");
  }
}
