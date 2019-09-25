package edu.csu2017fa314.T30.Controller;
import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.DataHandling;
import edu.csu2017fa314.T30.Model.User;
import org.apache.velocity.app.VelocityEngine;

import java.util.ArrayList;
import java.util.Properties;

import static spark.Spark.get;
import static spark.Spark.post;

public class JsonEffectController {

    VelocityEngine ve;
    Properties props;
    Gson gson;
    int test = 0;
    DataHandling datahandle;

    public JsonEffectController() {

        gson = new Gson();
        datahandle = new DataHandling();

        post("/jsonArrayListUsers", (request, response) ->{
            System.out.println("userhere");
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);

            ArrayList<User> Userlist = new ArrayList<User>();
            User u1  = new User("1","Mike", "Lynn", "email1");
            User u2  = new User("2","Mike", "Lynn", "email2");
            User u3  = new User("3","Mike", "Lynn", "email3");
            Userlist.add(u1);
            Userlist.add(u2);
            Userlist.add(u3);
            String json = gson.toJson(Userlist);
            System.out.println(json);
            return json;
        });

        get("/jsonMultiString", (request, response) ->{
            System.out.println("userhere");
            User user = new Gson().fromJson(request.body(), User.class);
            String[][] names = {
                    {"Sam", "Smith"},
                    {"Robert", "Delgro"},
                    {"James", "Gosling"},
            };
            String json = gson.toJson(names);
            System.out.println(json);
            return json;
        });

        post("/string", (request, response) ->{
            String test = "test";
            String json = gson.toJson(test);
            System.out.println(json);
            return json;
        });

        post("/jsonArrayList", (request, response) ->{
            System.out.println("userhere");
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            ArrayList<String> a1 = new ArrayList<String>();
            a1.add("Sam");
            a1.add("Smith");
            String json = gson.toJson(a1);
            System.out.println(json);
            return json;
        });

        post("/jsonArrayListofArrayList", (request, response) ->{
            System.out.println("userhere");
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);

            ArrayList<ArrayList<String> > aList = new ArrayList<ArrayList<String> >();
            ArrayList<String> a1 = new ArrayList<String>();
            a1.add("Sam");
            a1.add("Smith");
            aList.add(a1);

            ArrayList<String> a2 = new ArrayList<String>();
            a2.add("Robert");
            a2.add("Delgro");
            aList.add(a2);

            ArrayList<String> a3 = new ArrayList<String>();
            a3.add("James");
            a3.add("Delgro");
            aList.add(a3);

            String json = gson.toJson(aList);
            System.out.println(json);
            return json;
        });
    }


}
