package edu.csu2017fa314.T30;
import edu.csu2017fa314.T30.Controller.DataController;
import edu.csu2017fa314.T30.Controller.JsonEffectController;
import edu.csu2017fa314.T30.Controller.LayoutController;
import edu.csu2017fa314.T30.Controller.UserController;


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
      // routes
      new LayoutController();
      new UserController();
      new DataController();
      new JsonEffectController();
   }

}
