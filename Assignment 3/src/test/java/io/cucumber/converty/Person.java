package io.cucumber.converty;

import java.util.List;
import java.util.ArrayList;

public class Person {
  public void moveTo(Integer distance) {
  }
  public void shout(String message) {
  }
  public List<String> getMessagesHeard() {
    List<String> result = new ArrayList<String>();
    result.add("free bagels at Sean's");
    return result;
  }
}