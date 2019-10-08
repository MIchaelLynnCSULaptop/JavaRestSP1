[![Build Status](https://travis-ci.com/MIchaelLynnCSULaptop/JavaRestSP1.svg?token=aGqZALLZUKhc6eMrMJtK&branch=master)](https://travis-ci.com/MIchaelLynnCSULaptop/JavaRestSP1)

#Running the backend (server)

Install Java JDK

https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html

Install Maven 

https://dzone.com/articles/installing-maven

You have the option of opening this in an IDE like IntelliJ or from the command line.

## command line

First, navigate to the project root (where the pom.xml is located). Run the following to package the code into a jar:

$ mvn package

Now run the jar file by running the following code:

$ java -cp target\T30-0.0.1-SNAPSHOT.jar edu.csu2017fa314.T30.TripCo

## IDE

Import into IntelliJ as a maven project then run TripCO

#Run Frontend (Client)

Spark(Controller) and Spring Framework(View)

Run Fiddler to check endpoints

entry point http://localhost:4567/layout in browser to check routes
