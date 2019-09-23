package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.DataHandling;
import org.apache.velocity.app.VelocityEngine;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static spark.Spark.get;
import static spark.Spark.post;

public class DataController {
    VelocityEngine ve;
    Properties props;
    DataHandling myModel;
    Gson gson;


    public DataController() {

        ve = new VelocityEngine();
        props = new Properties();
        props.put("file.resource.loader.path", "C:/Users/aplus/Documents/GitHub/JavaRestSP1/T30-1.0/src/main/java/edu/csu2017fa314/T30/View/");
        ve.init(props);
        gson = new Gson();
        myModel = new DataHandling();

        post("/get", (request, response) -> {
            System.out.println("datahere");
            String[] result = myModel.searchData("Echo Brewing Company");
            // convert to json format
            // String mybuiltItinerary = gson.toJson(myModel.buildItinerary());
            //  System.out.println(Arrays.toString(result) + "here");
            Map<String, DataHandling> view = new HashMap<String, DataHandling>();
            view.put("message", myModel);
            return new VelocityTemplateEngine(ve).render(
                    new ModelAndView(view, "getdata.vm"));
        });


        post("/sort", (request, response) -> {
            System.out.println("datahere");
            Map<String, DataHandling> view = new HashMap<String, DataHandling>();
            view.put("message", myModel);
            return new VelocityTemplateEngine(ve).render(
                    new ModelAndView(view, "data.vm"));
        });


    }
}
