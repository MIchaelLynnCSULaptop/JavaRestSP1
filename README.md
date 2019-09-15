To use this project first make sure you have npm or yarn installed. These are dependency managers that will download everything you need for the project.

Running the frontend (web)
This should look familiar. First, navigate into the web directory and install all dependencies: // test6

$ cd web

$ npm install //Install all dependencies

npm should start downloading everything it needs to build the app.

To launch the app:

$ npm run dev

#Running the backend (server)
You have the option of opening this in an IDE like IntelliJ or from the command line.

First, navigate to the project root (where the pom.xml is located). Run the following to package the code into a jar:

$ mvn package

Now run the jar file by running the following code:

$ java -cp target\T30-0.0.1-SNAPSHOT.jar edu.csu2017fa314.T30.TripCo
load main class edu.csu2017fa314.T30.TripCo
