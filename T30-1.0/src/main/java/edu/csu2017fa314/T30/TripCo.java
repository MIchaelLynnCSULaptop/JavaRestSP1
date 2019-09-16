package edu.csu2017fa314.T30;
import edu.csu2017fa314.T30.Controller.UserController;
import edu.csu2017fa314.T30.Model.User;

public class TripCo
{

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

   public static void main(String[] args) {

      new UserController(new User());

   }

}
