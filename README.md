#Running the backend (server)
You have the option of opening this in an IDE like IntelliJ or from the command line.

First, navigate to the project root (where the pom.xml is located). Run the following to package the code into a jar:

$ mvn package
Now run the jar file by running the following code:

$ java -cp target\T30-0.0.1-SNAPSHOT.jar edu.csu2017fa314.T30.TripCo
load main class edu.csu2017fa314.T30.TripCo