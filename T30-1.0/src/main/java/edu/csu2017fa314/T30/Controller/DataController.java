package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.DataHandling;
import org.apache.velocity.app.VelocityEngine;

import java.util.Arrays;
import java.util.Properties;

import static spark.Spark.get;
import static spark.Spark.post;

public class DataController {
    VelocityEngine ve;
    Properties props;
    DataHandling myModel;
    Gson gson;


    public DataController() {

        gson = new Gson();
        myModel = new DataHandling();


        post("/sort", (request, response) -> {

            String[] result = myModel.searchData("Echo Brewing Company");
            Arrays.sort(result);
            response.type("application/json");
            return new Gson().toJson(result);
        });


    }
}
