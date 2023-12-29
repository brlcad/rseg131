Christopher Sean Morrison
RSEG-131 Software Testing Techniques
Assignment 4, 12 December 2023
====================================

This fourth assignment was implemented fully per the instructions.
Continuing from Assignment 1, there are automated tests implemented
that map to the test cases defined for that assignment.  As I
typically gravitate towards non-graphical interfaces, I decided to
switch things up with this last assignment and select the Selenium IDE
as our testing framework of choice.  I did briefly test out the
selenium-side-runner CLI (see screenshots), but didn't explore its
capabilities in depth.

I did discover and fix a couple subtle mistakes in my original test
plan, and replaced three tests that were mildly reduntant with other
more interesting tests.

I was fascinated to discover Google Calculator (and some others) do
not have a canonical notion of negative numbers which resulted in a
surprising test failure where square root of -2 resulted in -4.  I
learned that Google Calculator treats "-" on a number not as a
negative valued number but (effectively) intead as if multiplied by
-1, ie., "(-1*NUM)", and of course exponentiation takes precedence
over multiplication.  To fix the unexpected "-2^2=-4" result, the test
was of course changed to "(-2)^2=4" to satisfy our testing intent.

Test Artifacts
--------------

For this assignment, I created 112 tests that correspond with the
previous test plan including coverage of user interface (UI), basic
arithmetic (BA), scientific functionality (SF), and complex
expressions (CE).  In the development of tests, it was interesting to
learn the capabilities and limitations of Selenium as I had no prior
experience.  Tests categorically were either text input or graphical
input, relying predominantly on "send keys" and "click" actions
respectively with assertions as needed.  The most complex tests (e.g.,
ST-SF-030) required a bit of scripting to verify that computed values
involving random numbers were within an expected range, for example:

return !!document.getElementById('cwos') &&
+document.getElementById('cwos').textContent >= 0 &&
+document.getElementById('cwos').textContent <= 1;

The main limitation of this testing approach is that we access most of
the calculator's html elements directly by id or rpath, which appears
to be auto-generated and/or potentially subject to change.  Very few
elements on Google's site appeared to be fixed values, such as "q" for
search queries and "cwos" for the calcualtor result.  Using rpath
would obviously be a potential solution if the html elements are
indeed regenerated randomly, but will still be subject to failures
when page structure changes.

Traceability Matrix
-------------------

Included is "Google Calculator Test Matrix, Morrison.xlsx" which
provides a traceability matrix from test case IDs to test IDs, along
with final testing results (i.e., all tests pass all assertions).

There is presently a 1-to-1 correspondence of test cases to tests
given our test cases were considerably low-level in nature and did not
warrant being divided across multiple tests.  However, if we were to
need to introduce additional (e.g., non-Selenium) testing
infrastructure, cross-platform tests, or cross-browser tests, we could
end up with multiple test IDs mapping to the same test case IDs.

For matrix purposes, only Firefox on Mac was used.  I discovered in
the course of cross-browser testing that some of the tests would
possibly need additional logic added to account for differences in
rendering delays (as seen in "Screenshot 2023-12-12 at 6.08.27 PM"
where a test on Chrome had to retry to succeed).  All tests have a
check that the calculator displays before commencing with their
specifics.

Video and Screenshots
---------------------

Please see the included Screen*.mov video or Screenshot*.png images
showing the Selenium testing in action (both GUI and CLI).  The video
showcases Selenium IDE running through all 112 tests.  Note, one
failure was included in the video, but all are fixed, i.e., all tests
pass.  It's also interesting to note at the very end that running the
tests triggered an "unusual activity" detection and CAPTCHA from
Google to proceed.

Experiences with Selenium
-------------------------

Selenium was interesting to work with and clearly quite capable.
Given prior experience with html elements, css, and javascript,
Selenium was very easy to figure out without relying on documentation
or examples.  Contrary to the warnings shared by others, it did not
crash on me.  There were some delays after running for a while, but
they seemed to ameliorate by clearing the log and ensuring ample
system memory.

Biggest issue I ran into with Selenium is that I had to add an
explicit 'open' action despite defining a URL for the target website,
and that took quite some time to figure out.  Without it, html
elements would not be found and timeouts ensued.  Another issue was
needing to figure out how to stash html data into variables (mentioned
earlier) so that I could do more complex bounds checking of specific
results.  A minor nuisance was pop-up labels and delays in the GUI
that affected the user experience, often having to click actions
multiple times.  Despite turning on parallel in both the GUI and CLI,
neither appeared to actually invoke in parallel.

I definitely appreciated the ease at which tests could be defined,
albeit very tedious to define over a hundred even relatively simple
tests for Google Calculator.  If I were to do it again, I would likely
resort to direct editing of the .side text file or resorting to
writing WebDriver code.

Thank you for this course on software testing!
