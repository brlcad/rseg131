# compile
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar MyJUnitTest.java
javac -cp . mymath.java
javac -cp .:junit-platform-console-standalone-1.10.0.jar mymathtest.java

# JUnit v4 example
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore MyJUnitTest

# JUnit v5 example
java -jar junit-platform-console-standalone-1.10.0.jar --cp . -c mymathtest

