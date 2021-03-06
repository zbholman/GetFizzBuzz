# GetFizzBuzz
This is a FizzBuzz as a service application. The server supports an HTTP GET call that returns a JSON object that contains the fizz, buzz, and fizzbuzz values when given the upperbound.

# How to use
Run the application to start the HTTP Server

In a browser (or using another tool of choice), access localhost:8080/fizzbuzz/<number>

ex. localhost:8080/fizzbuzz/16

This will return the following JSON object
{"FizzBuzz":[15],"Fizz":[3,6,9,12],"Buzz":[5,10]}

# Prereqs
Java 1.8
For building - a Java IDE with maven support

# To Run
- clone project then follow based on your OS

On Mac
  - open root directory and double click mac_start_server.command
  
On Linux
  - clone project and open root directory
  - In terminal, use 'cd' to change directory to the project root, then run
  ```
  ./start_server.sh
  ```
  - alternatively, you can run
  ```
  java -jar <project_root>/GetFizzBuzz.jar
  ```
  or if you've already built the project
  ```
  java -jar <project_root>/target/GetFizzBuzz-0.0.1-SNAPSHOT-jar-with-dependencies.jar
  ```
  
On Windows
  - Open project root directory
  - Double click "GetFizzBuzz.jar" to run
  - Alternatively, you can follow build steps and run in IDE or execute jar from command line with
  ```
  java -jar <path_to_jar>
  ```
# To Build
- Open in your favorite IDE (I used eclipse)
- You can run right from the IDE, or if you'd prefer a standalone package continue to the following steps.
- Right click project or pom.xml and click Run As > Maven Install
- An executable jar named GetFizzBuzz-0.0.1-SNAPSHOT-jar-with-dependencies.jar will be generated in the "target" directory
- Open a terminal or command line window, and run java -jar <path_to_executable jar>
  ```
  java -jar /home/brian/GetFizzBuzz/target/GetFizzBuzz-0.0.1-SNAPSHOT-jar-with-dependencies.jar
  ```
