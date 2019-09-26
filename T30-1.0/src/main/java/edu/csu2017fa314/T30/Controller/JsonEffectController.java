package edu.csu2017fa314.T30.Controller;
import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.DataService;
import edu.csu2017fa314.T30.Model.User;
import edu.csu2017fa314.T30.Model.UserService;
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
    DataService datahandle;
    UserService usersContain;

    public JsonEffectController() {

        gson = new Gson();
        datahandle = new DataService();
        usersContain = new UserService();

        post("/jsonArrayListUsers", (request, response) ->{
            response.status(200);
            User user = new Gson().fromJson(request.body(), User.class);

            User u1  = new User("1","Mike", "Lynn", "email1");
            User u2  = new User("2","Mike", "Lynn", "email2");
            User u3  = new User("3","Mike", "Lynn", "email3");
            usersContain.addUser(u1);
            usersContain.addUser(u2);
            usersContain.addUser(u3);
           // String json = usersContain.getAllData();
            String json = usersContain.search("email1");
            System.out.println(json);
            return json;
        });

        post("/jsonMultiString", (request, response) ->{
            response.status(200);

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
            String test = "testing";
            if(!test.isEmpty()){
                response.status(200);
                String json = gson.toJson(test);
                System.out.println(json);
                return json;
            }
            response.status(400);
            String test2 = "Empty String";
            String json = gson.toJson(test2);
            return test2;
        });

        post("/jsonArrayList", (request, response) ->{
            response.status(200);
            User user = new Gson().fromJson(request.body(), User.class);
            ArrayList<String> a1 = new ArrayList<String>();
            a1.add("Sam");
            a1.add("Smith");
            String json = gson.toJson(a1);
            System.out.println(json);
            return json;
        });

        post("/jsonArrayListofArrayList", (request, response) ->{
            response.status(200);
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
