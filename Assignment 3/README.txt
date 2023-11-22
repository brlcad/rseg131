Christopher Sean Morrison
RSEG-131 Software Testing Techniques
Assignment 3, 21 November 2023
====================================

This third assignment was implemented fully per the instructions.
Carried over from Assignment 2, there is a Conversions class that
performs distance and temperature conversions.  There is now also a
Maven-based and Cucumber-based behavior-driven development (BDD) test
setup that validates the Conversions class behavior.  Included in the
BDD testing are positive cases, negative cases, testing of extreme
values, testing of invalid values, and more.

Compilation and running of the testing is provided via an included
compile.sh shell script which simply runs Maven for our BDD testing.

While we were still fundamentally testing a class, which begged for
lower-level unit-style testing, it was still very interesting to think
about the problem in terms of scenarios. This led to most positive
test cases being grouped together as "Scenario Outlines" for both unit
types.  It also allowed for the aggregation of code that sets values
or checks results, which seemed to be a marked improvement over the
previous unit testing code.

This assignment caught a bug in the previous distance unit management
where unit types were being compared with equality (==) operator
(e.g., unit == "mm").  This coincidentally worked with JUnit's testing
setup, but resulted in invalid conversions and test failures in
Cucumber's test environment.  Correcting the distance unit management
to .equals() of course fixed the bug.

Thinking about the environment from a behavior perspective also helped
me realize a couple test cases that had not been previously
considered, namely using temperature units for distance conversion and
vice versa.

Please see the attached screenshots and/or video showing the
Cucumber-based BDD testing in action.  Thanks!

