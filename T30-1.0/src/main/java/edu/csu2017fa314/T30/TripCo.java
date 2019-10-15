package edu.csu2017fa314.T30;
import edu.csu2017fa314.T30.Controller.DataController;
import edu.csu2017fa314.T30.Controller.JsonEffectController;
import edu.csu2017fa314.T30.Controller.LayoutController;
import edu.csu2017fa314.T30.Controller.UserController;
import edu.csu2017fa314.T30.Model.DataBase.DataBase;
import static spark.Spark.*;

import java.sql.SQLException;


public class TripCo
{

   static int getHerokuAssignedPort() {
      ProcessBuilder processBuilder = new ProcessBuilder();
      if (processBuilder.environment().get("PORT") != null) {
         return Integer.parseInt(processBuilder.environment().get("PORT"));
      }
      return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
   }

   private String name = "";

   public String getName()
   {
      return name;
   }

   public String getMessage()
   {
      if (name == "")
      {
         return "Hello!";
      }
      else
      {
         return "Hello " + name + "!";
      }
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public static void main(String[] args) throws SQLException {
    //  port(8080); // Spark will run on port 8080

      DataBase db = new DataBase();
      db.myDataBase();
      new LayoutController();
      new UserController();
      new DataController();
      new JsonEffectController();
   }


}
