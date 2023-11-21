Christopher Sean Morrison
RSEG-131 Software Testing Techniques
Assignment 2, November 2024
====================================

This second assignment was implemented successfully per the
instruction criteria.  There is a Conversions class that performs
distance and temperature conversions.  There is a ConversionsTest
class that implements 30 unit tests.

Included in the unit testing are positive tests, negative tests, a
handful of smoke tests, edge testing for interesting/boundary values,
and equivalence class spot-testing.

As for determining which test cases to include and how I determined
that the existing cases provide sufficient test coverage, I primarily
utilized equivalence classes to make sure each of the directional
conversions work as expected (i.e., the positive tests) in each
direction.  I then also ensure that all of the expected failure cases
do indeed fail as expected -- which included the specification of an
unknown unit as well as "invalid" values.  For the purpose of this
assignment, I defined invalid as being Not-A-Number (NaN) and Infinity
(Inf) input values.  Lastly, I added additional checks for common
boundary conditions such as special values (e.g., zero values, large
values, negative values, overflow, and underflow).

While I didn't exhaustively test all unit pairings, the approach of
spot-testing particular cases was deemed adequate because the
implementation was known to use composition so, for example, all input
values regardless of unit type are tested for validity.  As such,
adding additional tests results in no additional code coverage.

Compilation and running of all tests is provided via the included
compile.sh shell script (the contents of which should also run on
Windows either via git-bash or cmd.exe).

Unit tests are run via the junit standalone console, for which output
can be seen in the included Screenshot*.png image.

No issues were encountered for this interesting assignment. Thank you!


---
Full Disclosure: I am a primary author and maintainer for BRL-CAD's
basic utility library which includes unit conversion API [1].  I did
not reference or incorporate any of BRL-CAD's conversion code, but my
familiarity may have inspired or influenced me regardless.

[1] https://github.com/BRL-CAD/brlcad/blob/main/src/libbu/units.c

Ironically, BRL-CAD does not currently have any unit testing
implemented for its conversion API, so this assignment may get put to
future use there.
