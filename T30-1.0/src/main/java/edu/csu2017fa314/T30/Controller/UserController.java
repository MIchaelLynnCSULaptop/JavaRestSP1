package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Model;
import edu.csu2017fa314.T30.Model.User;
import org.apache.velocity.app.VelocityEngine;
import java.util.Properties;
import static spark.Spark.*;



public class UserController {
    VelocityEngine ve;
    Properties props;
    Gson gson;
    int test = 0;



    public UserController() {

//        // minium default to run
//        get("/users", (request, response) -> {
//            return new ModelAndView(new HashMap(), "main.vm");
//        }, new VelocityTemplateEngine());

        gson = new Gson();


        post("/user", (request, response) ->{
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            System.out.println(user.id);
            return new Gson().toJson(user);
        });

    }
}