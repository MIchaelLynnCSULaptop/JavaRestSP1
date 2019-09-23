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

public class MainController {
    VelocityEngine ve;
    Properties props;
    DataHandling myModel;
    Gson gson;

    public MainController() {

        // without this you have to have the "main.vm" in /main/resources/main.vm
         ve = new VelocityEngine();
         props = new Properties();
         props.put("file.resource.loader.path", "C:/Users/aplus/Documents/GitHub/JavaRestSP1/T30-1.0/src/main/java/edu/csu2017fa314/T30/View/");
         ve.init(props);

        myModel = new DataHandling();
        gson = new Gson();

        get("/main", (request, response) -> {

            String[] result = myModel.searchData("Echo Brewing Company");
            // convert to json format
            // String mybuiltItinerary = gson.toJson(myModel.buildItinerary());
            System.out.println(Arrays.toString(result) + "here");
            Map<String, Object> view = new HashMap<String, Object>();
            view.put("message", result);
            return new VelocityTemplateEngine(ve).render(
                    new ModelAndView(view, "main.vm"));

        });

    }
}
