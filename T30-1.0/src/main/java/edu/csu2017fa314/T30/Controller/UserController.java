package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Model;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static spark.Spark.*;


public class UserController {

    int test = 0;

    public String callme(Model myusers) {

//        VelocityEngine ve = new VelocityEngine();
//        Properties props = new Properties();
//        props.put("file.resource.loader.path", "/Users/aplus/Documents/GitHub/JavaRestSP1/T30-1.0/resources/");
//        ve.init(props);
//
//        Template t = ve.getTemplate("hello.vm");
//        VelocityContext context = new VelocityContext();
//        String templateVariable = "Hello Velocity!";
//        context.put("message",templateVariable);  // put your template values here
//        StringWriter writer = new StringWriter();
//        t.merge(context, writer);
//
//        System.out.println(writer.toString()); // print the updated template as string

        test++;
        System.out.println(test);
        System.out.println("Hello ");
        myusers.readData();
        Gson gson = new Gson();
        String mybuiltItinerary = gson.toJson(myusers.buildItinerary());
        return mybuiltItinerary;
    }

    public UserController(final Model myusers) {

//        // minium default to run
//        get("/users", (request, response) -> {
//            return new ModelAndView(new HashMap(), "hello.vm");
//        }, new VelocityTemplateEngine());

        get("/users", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String templateVariable = "Hello Velocity!";
            model.put("message", templateVariable);
            return new ModelAndView(model, "hello.vm");

        }, new VelocityTemplateEngine());


        // get("/users", (req, res) -> callme(myusers));

        after((req, res) -> {
            res.type("application/json");
        });

// more routes
    }
}