package io.cucumber.converty;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

  @ParameterType("F|C|mi|yd|ft|in|km|m|dm|cm|mm")
  public String unit(String unit) {
    return unit;
  }
}
