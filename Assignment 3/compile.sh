#!/bin/sh

# Compile and run our built-in main.
javac Conversions.java
java Conversions

# Run the behavior tests.
mvn clean test

