package edu.csu2017fa314.T30.Model;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;

public class DataHandling {

    public String[][] data;
    Model myModel;
    Gson gson;

    public DataHandling ()
    {
        data = new String[3][];
        myModel = new Model();
        myModel.readData();
        data = myModel.buildItinerary();
        gson = new Gson();
    }

    public String getAllData() {
        // Convert Java objects to JSON
        String test = gson.toJson(data);
        System.out.println(test);
        return test;
    }

    public String search(String searchVal) {
        String[] result = new String[3];

        // get single object entry
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(searchVal)) {
                result = Arrays.copyOf(data[i], 3);
            }
        }
        String test = gson.toJson(result);
        System.out.println(test);
     return test;
    }

    public String sort(String searchVal) {
        String[] result = new String[3];

        // get single object entry
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(searchVal)) {
                result = Arrays.copyOf(data[i], 3);
            }
        }
        Arrays.sort(result);
        String test = gson.toJson(result);
        System.out.println(test);
        return test;
    }




}
