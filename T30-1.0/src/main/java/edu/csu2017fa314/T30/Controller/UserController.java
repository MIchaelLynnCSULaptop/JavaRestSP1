package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Model;
import edu.csu2017fa314.T30.Model.User;
import edu.csu2017fa314.T30.View.Hello;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static spark.Spark.*;
import static spark.route.HttpMethod.post;


public class UserController {
    VelocityEngine ve;
    Properties props;
    Model myModel;
    Hello myHelloView;
    Gson gson;
    int test = 0;



    public UserController() {

//        // minium default to run
//        get("/users", (request, response) -> {
//            return new ModelAndView(new HashMap(), "hello.vm");
//        }, new VelocityTemplateEngine());


        myModel = new Model();
        myHelloView = new Hello();
        gson = new Gson();

        // without this you have to have the "hello.vm" in /main/resources/hello.vm
       // ve = new VelocityEngine();
       // props = new Properties();
       // props.put("file.resource.loader.path", "C:/Users/aplus/Documents/GitHub/JavaRestSP1/T30-1.0/src/main/java/edu/csu2017fa314/T30/View/");
        //ve.init(props);
        // "note pass return new VelocityTemplateEngine(!!!!!!!!!ve!!!!!!!!!!) into REST render to get new directory"


        post("/users", (request, response) ->{
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            System.out.println(user.id);
            return new Gson().toJson(user);
        });

        get("/home", (request, response) -> {

            myModel.readData();
            String[][] testing = myModel.buildItinerary();
            String searchVal = "Echo Brewing Company";
            String[] result = new String[3];

            // get single object entry
            for (int i = 0; i < testing.length ; i++)
            {
                if (testing[i][0].equals(searchVal)) {
                    result = Arrays.copyOf(testing[i], 3);
                }
            }
            // convert to json format
            // String mybuiltItinerary = gson.toJson(myModel.buildItinerary());
            System.out.println(Arrays.toString(result) + "here");
            myHelloView.setview(testing, result);
            return new VelocityTemplateEngine().render(
                    new ModelAndView(myHelloView.getview(), "home.vm"));
        });

        get("/users", (request, response) -> {

                    myModel.readData();
                    String[][] testing = myModel.buildItinerary();
                    String searchVal = "Echo Brewing Company";
                    String[] result = new String[3];

                    // get single object entry
                    for (int i = 0; i < testing.length ; i++)
                    {
                            if (testing[i][0].equals(searchVal)) {
                                result = Arrays.copyOf(testing[i], 3);
                        }
                    }
                     // convert to json format
                   // String mybuiltItinerary = gson.toJson(myModel.buildItinerary());
                     System.out.println(Arrays.toString(result) + "here");
                    myHelloView.setview(testing, result);
                     return new VelocityTemplateEngine().render(
                        new ModelAndView(myHelloView.getview(), "hello.vm"));

        });

        // get("/users", (req, res) -> callme(myusers));

//        after((req, res) -> {
//            res.type("application/json");
//        });

//        after((req, res) -> {
//            res.type("text/html; charset=utf-8");
//        });

// more routes
    }
}