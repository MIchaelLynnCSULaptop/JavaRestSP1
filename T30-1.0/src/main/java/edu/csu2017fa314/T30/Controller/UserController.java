package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Model;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class UserController {

    int test = 0;

    public String callme(Model myusers) {
        test++;
        System.out.println(test);
        System.out.println("Hello ");
        myusers.readData();
        Gson gson = new Gson();
        String mybuiltItinerary = gson.toJson(myusers.buildItinerary());
        return mybuiltItinerary;
    }

    public UserController(final Model myusers) {

        get("/users", (req, res) -> {
                    callme(myusers);
                    Map<String, Object> model = new HashMap<>();
                    model.put("hello", "Velocity World");
                    return new ModelAndView(model, "hello.vt");
                }, new VelocityTemplateEngine());


        after((req, res) -> {
            res.type("application/json");
        });

// more routes
    }
}