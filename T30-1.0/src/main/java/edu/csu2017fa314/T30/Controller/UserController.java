package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Users.User.BaseUser;
import edu.csu2017fa314.T30.Model.Users.User.User;
import edu.csu2017fa314.T30.Model.Users.User.UserService;
import org.apache.velocity.app.VelocityEngine;
import java.util.Properties;
import static spark.Spark.*;



public class UserController {
    VelocityEngine ve;
    Properties props;
    Gson gson;
    int test = 0;
    BaseUser myUsersInterface;



    public UserController() {

    gson = new Gson();
    myUsersInterface = new UserService();

    post("/user", (request, response) ->{
        response.status(200);
        response.type("application/json");
        User user = new Gson().fromJson(request.body(), User.class);
        String json = gson.toJson(user.id);
        System.out.println(json);
        return json;
    });

        post("/usersearch", (request, response) ->{
            response.status(200);
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            String json = myUsersInterface.search("email1");
            System.out.println(json);
            return json;
        });

        post("/addUsers", (request, response) ->{
            response.status(200);
            User user = new Gson().fromJson(request.body(), User.class);

            User u1  = new User("1","Mike", "Lynn", "email1");
            User u2  = new User("2","Mike", "Lynn", "email2");
            User u3  = new User("3","Mike", "Lynn", "email3");
            myUsersInterface.addUser(u1);
            myUsersInterface.addUser(u2);
            myUsersInterface.addUser(u3);
            String json = myUsersInterface.getAllData();
            return json;
        });

}
}