#!/bin/sh

# Compile and run our built-in main.
javac Conversions.java
java Conversions

# Original compilation of unit testing:
# javac -cp .:junit-jupiter-api-5.10.0.jar:junit-jupiter-engine-5.10.0.jar:apiguardian-api-1.1.2.jar ConversionsTest.java

# Apparently this works too, and is more simple:
javac -cp .:junit-platform-console-standalone-1.10.0.jar ConversionsTest.java

# Run the unit tests.
java -jar junit-platform-console-standalone-1.10.0.jar --cp . -c ConversionsTest # --scan-classpath

