package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.User;

import static spark.Spark.*;

public class UserController {

    public UserController(final User myusers) {
        myusers.id = "1";

        Gson gson = new Gson();
        String json = gson.toJson(myusers);
        get("/users", (req, res) -> json);

        after((req, res) -> {
            res.type("application/json");
        });

// more routes
    }
}